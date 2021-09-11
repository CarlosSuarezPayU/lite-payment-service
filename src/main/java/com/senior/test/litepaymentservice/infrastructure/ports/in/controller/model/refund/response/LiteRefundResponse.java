package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LiteRefundResponse {

	private String transactionId;

	private TransactionType transactionType;

	private TransactionState transactionState;

	private Integer paymentOrderId;

	private String responseCode;

	private String responseMessage;

	private Timestamp transactionCreation;
}
