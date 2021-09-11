package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request;

import javax.validation.constraints.NotBlank;
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
public class LiteRefundRequest {

	@NotBlank
	private final String transactionParentId;

	@NotBlank
	private final TransactionType transactionType;

}
