package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class Payer {

	@NotBlank
	private final String fullName;

	@NotBlank
	private final String identification;

	@NotBlank
	@Enumerated(value = EnumType.STRING)
	private final IdentificationType identificationType;

	@NotBlank
	private final String email;

	@NotBlank
	private final String address;

	private final String phone;

}
