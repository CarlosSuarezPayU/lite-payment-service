package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class LitePaymentResponse {

	private final String transactionId;

	private final TransactionType transactionType;

	private final TransactionState transactionState;

	private final String responseCode;

	private final String responseMessage;

	private final Timestamp transactionCreation;

}
