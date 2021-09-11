package com.senior.test.litepaymentservice.share.model.antifraud.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class AntiFraudRequest {

	private final AntiFraudCreditCard creditCard;

	private final AntiFraudPayer payer;

}

