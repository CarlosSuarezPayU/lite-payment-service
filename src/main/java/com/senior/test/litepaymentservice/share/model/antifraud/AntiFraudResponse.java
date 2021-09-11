package com.senior.test.litepaymentservice.share.model.antifraud;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Response model for anti fraud service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@ToString
public class AntiFraudResponse {

	private final boolean isFraud;

	private final String message;

}
