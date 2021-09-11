package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request;

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
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

	@NotBlank
	@Size(min = 14, max = 19)
	private String panNumber;

	@NotBlank
	@Size(max = 3)
	private String cvv2;

	@NotBlank
	@JsonFormat(pattern = "MM-yy")
	private String expirationDate;

	@NotBlank
	private String name;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private FranchiseCard franchiseCard;

}
