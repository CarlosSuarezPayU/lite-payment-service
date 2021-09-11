package com.senior.test.litepaymentservice.application.wiremock;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.senior.test.litepaymentservice.application.wiremock.model.MockServerConfiguration;

@Configuration
@EnableConfigurationProperties(MockServerConfiguration.class)
public class WiremockServiceConfiguration {

	@Bean
	public MockServerStarter createMocks(final MockServerConfiguration mockServiceProperties) {

		final MockServerStarter mockServerStarter = new MockServerStarter(mockServiceProperties);
		mockServerStarter.startMocks();
		return mockServerStarter;
	}

}
