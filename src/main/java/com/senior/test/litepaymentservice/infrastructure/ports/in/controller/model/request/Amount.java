package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.CountryCurrency;
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
public class Amount {

	@NotNull
	@DecimalMin(value = "20000")
	private final BigDecimal value;

	private final BigDecimal tax;

	@NotNull
	@DecimalMin(value = "20000")
	private final BigDecimal total;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private final CountryCurrency currency;

}
