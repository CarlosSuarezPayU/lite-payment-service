package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.refund.reponse.BankRefundResponse;
import com.senior.test.litepaymentservice.share.model.refund.request.BankRefundRequest;

public interface PaymentNetworkProvider {

	BankPaymentResponse doPayment(final BankPaymentRequest bankPaymentRequest);

	BankRefundResponse doRefund(final BankRefundRequest bankRefundRequest);

}
