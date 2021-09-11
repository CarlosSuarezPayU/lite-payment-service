package com.senior.test.litepaymentservice.usecase.payment;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentValidator {

	//TO:DO validate credit card length, validate cvv2 length, validate person id length
	public static boolean isValidPaymentRequest(final LitePaymentRequest litePaymentRequest,
												final LitePaymentResponse.LitePaymentResponseBuilder response){
		return true;
	}
}
