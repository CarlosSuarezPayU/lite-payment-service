package com.senior.test.litepaymentservice.usecase.payment;

import static java.util.Objects.isNull;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.share.exception.PaymentException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentValidator {

	//TO:DO validate credit card length, validate cvv2 length, validate person id length
	public static boolean isValidPaymentRequest(final LitePaymentRequest litePaymentRequest) {

		final var messageError = new StringBuilder();
		var isValid = true;
		messageError.append("The transaction id has the following errors: ");
		if (isNull(litePaymentRequest.getTransactionType())) {
			messageError.append("The transactionType value must not be null");
			isValid = false;
		}
		if (!isValid) {
			throw new PaymentException(messageError.toString());
		}
		return isValid;
	}
}
