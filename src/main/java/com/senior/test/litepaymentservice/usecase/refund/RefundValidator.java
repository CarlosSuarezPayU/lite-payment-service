package com.senior.test.litepaymentservice.usecase.refund;

import static java.util.Objects.isNull;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.share.exception.PaymentException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RefundValidator {

	public static boolean isValidRefundRequest(final LiteRefundRequest liteRefundRequest) {

		final var messageError = new StringBuilder();
		var isValid = true;
		messageError.append("The transaction id has the following errors: ");
		if (isNull(liteRefundRequest.getTransactionParentId())) {
			messageError.append("The transactionParentId must not be null");
			isValid = false;
		}
		if (!isValid) {
			throw new PaymentException(messageError.toString());
		}
		return isValid;
	}

}
