package com.senior.test.litepaymentservice.share.model.refund.reponse;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Response model for refund to bank service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankRefundResponse {

	private String transactionId;

	private Timestamp creationDate;

	private BankPaymentResponseCode responseCode;

	private String message;

}
