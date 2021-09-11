package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;

public interface PaymentNetworkProvider {

	BankPaymentResponse doPayment(final BankPaymentRequest bankPaymentRequest);

}
