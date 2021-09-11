package com.senior.test.litepaymentservice.share.model.refund.reponse;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class BankRefundResponse {

	private final String transactionId;

	private final Timestamp creationDate;

	private final BankPaymentResponseCode responseCode;

	private final String message;


}
