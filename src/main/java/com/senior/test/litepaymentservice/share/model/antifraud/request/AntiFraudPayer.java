package com.senior.test.litepaymentservice.share.model.antifraud.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senior.test.litepaymentservice.share.model.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class AntiFraudPayer {

	private final String fullName;

	private final String identification;

	private final IdentificationType identificationType;

}
