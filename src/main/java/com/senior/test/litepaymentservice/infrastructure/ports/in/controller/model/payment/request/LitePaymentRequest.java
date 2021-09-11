package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class LitePaymentRequest {

	@NotNull(message = "The transaction type is mandatory")
	@Valid
	private final TransactionType transactionType;

	@NotNull(message = "The payer info is mandatory")
	@Valid
	private final Payer payer;

	@NotNull(message = "The amount info is mandatory")
	@Valid
	private final Amount amount;

	@NotNull(message = "The credit card info is mandatory")
	@Valid
	private final CreditCard creditCard;

}
