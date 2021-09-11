package com.senior.test.litepaymentservice.share.model.refund.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class BankRefundRequest {

	private final String transactionId;

	private final BigDecimal amount;

}
