package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Request model for payment controller.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LitePaymentRequest {

	private TransactionType transactionType;

	@NotNull(message = "The payer info is mandatory")
	@Valid
	private Payer payer;

	@NotNull(message = "The amount info is mandatory")
	@Valid
	private Amount amount;

	@NotNull(message = "The credit card info is mandatory")
	@Valid
	private CreditCard creditCard;

}
