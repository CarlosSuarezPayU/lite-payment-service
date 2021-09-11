package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.repository.PaymentOrder;

public interface PaymentMapper {

	BankPaymentRequest toBank(final LitePaymentRequest litePaymentRequest, final String transactionId);

	void toLitePayment(final BankPaymentResponse bankPaymentResponse, final TransactionType transactionType,
					   final LitePaymentResponse.LitePaymentResponseBuilder response);

}