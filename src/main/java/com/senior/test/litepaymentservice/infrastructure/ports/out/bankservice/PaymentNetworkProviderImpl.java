package com.senior.test.litepaymentservice.infrastructure.ports.out.bankservice;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
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
		log.info("Response from Bank-Client {}", response);
		return response;
	}
}
