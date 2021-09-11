package com.senior.test.litepaymentservice.share.util;

import static com.senior.test.litepaymentservice.share.constant.LitePaymentConstants.MASK_LEFT_LENGTH;
import static com.senior.test.litepaymentservice.share.constant.LitePaymentConstants.MASK_RIGHT_LENGTH;
import static com.senior.test.litepaymentservice.share.constant.LitePaymentConstants.MASK_VALUE;

/**
 * Utils methods for lite payment.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
public class LitePaymentUtil {

	public static String maskCreditCardNumber(final String fullCreditCardNumber) {

		final var maskedCardNumber = new StringBuilder();

		maskedCardNumber.append(fullCreditCardNumber.substring(0, MASK_RIGHT_LENGTH));
		maskedCardNumber.append(MASK_VALUE);
		maskedCardNumber.append(fullCreditCardNumber.substring(fullCreditCardNumber.length() - MASK_LEFT_LENGTH));

		return maskedCardNumber.toString();
	}
}
