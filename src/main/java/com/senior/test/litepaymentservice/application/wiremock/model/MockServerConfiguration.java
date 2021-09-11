package com.senior.test.litepaymentservice.application.wiremock.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wiremock.mocks")
public class MockServerConfiguration {

	private Map<String, MockProperties> services = new HashMap<>();

	public Map<String, MockProperties> getServices() {

		return services;
	}
}