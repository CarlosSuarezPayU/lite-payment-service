package com.senior.test.litepaymentservice.share.model.payment.response;

import com.senior.test.litepaymentservice.share.model.TransactionState;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Response codes for bank service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Getter
@AllArgsConstructor
public enum BankPaymentResponseCode {
	SUCCESS("01", TransactionState.APPROVED),
	INSUFFICIENT_FUNDS("30", TransactionState.DECLINED),
	ERROR("50", TransactionState.ERROR),
	NOT_ALLOW("40", TransactionState.DECLINED);
	private final String responseCode;
	private final TransactionState transactionState;
}
