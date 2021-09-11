package com.senior.test.litepaymentservice.application.wiremock.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Class to define the mock properties to read from the properties.yaml.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Getter
@Setter
public class MockProperties {

	private boolean enabled;
	private int port;
	private String resourcesPath;

}
