package com.senior.test.litepaymentservice.usecase.payment;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;

public interface PaymentUseCase {

	LitePaymentResponse execute(LitePaymentRequest litePaymentRequest);


}
