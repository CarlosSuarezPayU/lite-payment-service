package com.senior.test.litepaymentservice.share.model.payment.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.CountryCurrency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Amount model for payment to bank service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankPaymentAmount {

	private BigDecimal value;

	private BigDecimal tax;

	private BigDecimal total;

	private CountryCurrency currency;

}
