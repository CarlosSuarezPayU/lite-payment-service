package com.senior.test.litepaymentservice.infrastructure.ports.out.bankservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.refund.reponse.BankRefundResponse;
import com.senior.test.litepaymentservice.share.model.refund.request.BankRefundRequest;

/**
 * Bank network feign client definition.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@FeignClient(name = "network", url = "${services.network.url}")
public interface BankPaymentFeingClient {

	@PostMapping(value = "/payment", consumes = "application/json")
	BankPaymentResponse createPayment(final BankPaymentRequest bankPaymentRequest);

	@PostMapping(value = "/refund", consumes = "application/json")
	BankRefundResponse createRefund(final BankRefundRequest bankRefundRequest);

}
