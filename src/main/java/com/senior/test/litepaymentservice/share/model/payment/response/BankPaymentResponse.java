package com.senior.test.litepaymentservice.share.model.payment.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Response model for payment to bank service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankPaymentResponse {


	private String transactionId;

	private Timestamp creationDate;

	private BankPaymentResponseCode responseCode;

	private String message;

}
