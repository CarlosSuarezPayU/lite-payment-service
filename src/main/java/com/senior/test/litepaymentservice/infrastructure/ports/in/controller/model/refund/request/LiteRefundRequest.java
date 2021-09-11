package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.CreditCard;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.Payer;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Request model for refund endpoint controller.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LiteRefundRequest {

	private String transactionParentId;

	@NotNull(message = "The transaction type is mandatory")
	@Valid
	@Enumerated(value = EnumType.STRING)
	private TransactionType transactionType;

	@NotNull(message = "The credit card info is mandatory")
	@Valid
	private CreditCard creditCard;

	@NotNull(message = "The payer info is mandatory")
	@Valid
	private Payer payer;

}
