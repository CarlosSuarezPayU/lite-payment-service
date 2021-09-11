package com.senior.test.litepaymentservice.usecase.payment;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;

public interface PaymentUseCase {

	LitePaymentResponse execute(final LitePaymentRequest litePaymentRequest);


}
