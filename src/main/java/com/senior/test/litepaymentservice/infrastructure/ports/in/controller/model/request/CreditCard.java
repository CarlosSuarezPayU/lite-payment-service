package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.FranchiseCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
public class CreditCard {

	@NotBlank
	@Size(min=14, max=19)
	private final String panNumber;

	@NotBlank
	@Size(max=3)
	private final String cvv2;

	@NotBlank
	@JsonFormat(pattern = "MM-yy")
	private final String expirationDate;

	@NotBlank
	private final String name;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private final FranchiseCard franchiseCard;

}
