package com.senior.test.litepaymentservice.share.model.payment.response;

import com.senior.test.litepaymentservice.share.model.TransactionState;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BankPaymentResponseCode {
	SUCCESS("01", TransactionState.APPROVED),
	INSUFFICIENT_FUNDS("30", TransactionState.DECLINED),
	NOT_ALLOW("40", TransactionState.DECLINED);
	private final String responseCode;
	private final TransactionState transactionState;
}
