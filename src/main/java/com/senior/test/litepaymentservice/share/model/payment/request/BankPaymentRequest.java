package com.senior.test.litepaymentservice.share.model.payment.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Request for payment to bank service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankPaymentRequest {

	private String transactionId;

	private String payerIdentificationId;

	private BankPaymentCreditCard card;

	private BankPaymentAmount amount;


}
