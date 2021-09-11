package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request;

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
@NoArgsConstructor
@ToString
public class Payer {

	@NotBlank
	private String fullName;

	@NotBlank
	private String identification;

	@NotBlank
	@Enumerated(value = EnumType.STRING)
	private IdentificationType identificationType;

	@NotBlank
	private String email;

	@NotBlank
	private String address;

	private String phone;

}
