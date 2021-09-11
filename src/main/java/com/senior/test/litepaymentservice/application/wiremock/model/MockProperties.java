package com.senior.test.litepaymentservice.application.wiremock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MockProperties {

	private boolean enabled;
	private int port;
	private String resourcesPath;

}
