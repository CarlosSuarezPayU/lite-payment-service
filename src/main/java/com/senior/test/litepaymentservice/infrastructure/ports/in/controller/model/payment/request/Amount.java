package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request;

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
@NoArgsConstructor
@ToString
public class Amount {

	@NotNull
	@DecimalMin(value = "20000")
	private BigDecimal value;

	private BigDecimal tax;

	@NotNull
	@DecimalMin(value = "20000")
	private BigDecimal total;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private CountryCurrency currency;

}
