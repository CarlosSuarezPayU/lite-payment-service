package com.senior.test.litepaymentservice.share.model.refund.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Request model for refund to bank service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class BankRefundRequest {

	private final String transactionId;

	private final BigDecimal amount;

	private final String payerIdentificationId;

	private final String cardNumber;

}
