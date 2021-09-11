package com.senior.test.litepaymentservice.usecase.payment;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;

/**
 * Class definition of the payment process.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
public interface PaymentUseCase {

	LitePaymentResponse execute(final LitePaymentRequest litePaymentRequest);

}
