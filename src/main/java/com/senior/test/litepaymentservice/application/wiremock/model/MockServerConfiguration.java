package com.senior.test.litepaymentservice.application.wiremock.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration to read mock properties to from the properties.yaml.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@ConfigurationProperties(prefix = "wiremock.mocks")
public class MockServerConfiguration {

	private Map<String, MockProperties> services = new HashMap<>();

	public Map<String, MockProperties> getServices() {

		return services;
	}
}