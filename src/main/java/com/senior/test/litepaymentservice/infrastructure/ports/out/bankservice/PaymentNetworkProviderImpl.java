package com.senior.test.litepaymentservice.infrastructure.ports.out.bankservice;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.refund.reponse.BankRefundResponse;
import com.senior.test.litepaymentservice.share.model.refund.request.BankRefundRequest;
import com.senior.test.litepaymentservice.usecase.share.PaymentNetworkProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentNetworkProviderImpl implements PaymentNetworkProvider {

	private final BankPaymentFeingClient bankPaymentFeingClient;

	@Override public BankPaymentResponse doPayment(final BankPaymentRequest bankPaymentRequest) {

		final var response = bankPaymentFeingClient.createPayment(bankPaymentRequest);
		log.info("Feing client payment response {}", response);
		return response;
	}

	@Override public BankRefundResponse doRefund(final BankRefundRequest bankRefundRequest) {

		final var response = bankPaymentFeingClient.createRefund(bankRefundRequest);
		log.info("Feing client refund response  {}", response);
		return response;
	}
}
