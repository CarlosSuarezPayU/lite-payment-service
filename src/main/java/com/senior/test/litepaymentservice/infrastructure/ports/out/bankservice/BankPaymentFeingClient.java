package com.senior.test.litepaymentservice.infrastructure.ports.out.bankservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;

@FeignClient(name = "network", url = "${services.network.url}")
public interface BankPaymentFeingClient {

	@PostMapping(value = "/payment", consumes = "application/json")
	BankPaymentResponse createPayment(final BankPaymentRequest bankPaymentRequest);

}
