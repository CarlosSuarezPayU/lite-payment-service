package com.senior.test.litepaymentservice.infrastructure.ports.out.bankservice;

import static com.senior.test.litepaymentservice.share.constant.LitePaymentConstants.NETWORK_NAME;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponseCode;
import com.senior.test.litepaymentservice.share.model.refund.reponse.BankRefundResponse;
import com.senior.test.litepaymentservice.share.model.refund.request.BankRefundRequest;
import com.senior.test.litepaymentservice.usecase.share.PaymentNetworkProvider;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Defines the implementation of the operations provided by the bank network.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentNetworkProviderImpl implements PaymentNetworkProvider {

	private final BankPaymentFeingClient bankPaymentFeingClient;

	@Override
	@CircuitBreaker(name = NETWORK_NAME, fallbackMethod = "doPaymentFallback")
	public BankPaymentResponse doPayment(final BankPaymentRequest bankPaymentRequest) {

		final var response = bankPaymentFeingClient.createPayment(bankPaymentRequest);
		log.info("Feing client payment response [{}]", response);
		return response;
	}

	@Override
	@CircuitBreaker(name = NETWORK_NAME, fallbackMethod = "doRefundFallback")
	public BankRefundResponse doRefund(final BankRefundRequest bankRefundRequest) {

		final var response = bankPaymentFeingClient.createRefund(bankRefundRequest);
		log.info("Feing client refund response  [{}]", response);
		return response;
	}

	private BankPaymentResponse doPaymentFallback(final BankPaymentRequest bankPaymentRequest,
												  final Throwable throwable) {

		log.warn("The transaction id: [{}] was processed with fallback method.", bankPaymentRequest.getTransactionId());

		return BankPaymentResponse.builder()
								  .withResponseCode(BankPaymentResponseCode.ERROR)
								  .withMessage(String.format("Payment fallback exception [{%s}]", throwable.getMessage()))
								  .build();
	}

	private BankRefundResponse doRefundFallback(final BankRefundRequest bankRefundRequest,
												final Throwable throwable) {

		log.warn("The transaction id: [{}] was processed with fallback method.", bankRefundRequest.getTransactionId());

		return BankRefundResponse.builder()
								 .withResponseCode(BankPaymentResponseCode.ERROR)
								 .withMessage(String.format("Refund fallback exception [{%s}]", throwable.getMessage()))
								 .build();
	}
}
