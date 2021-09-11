package com.senior.test.litepaymentservice.application.wiremock;

import static java.util.Objects.nonNull;

import java.net.URL;
import com.github.tomakehurst.wiremock.WireMockServer;

import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.senior.test.litepaymentservice.application.wiremock.model.MockProperties;
import com.senior.test.litepaymentservice.application.wiremock.model.MockServerConfiguration;
import lombok.extern.slf4j.Slf4j;

/**
 * Class to init the mock services.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Slf4j
public class MockServerStarter {

	private static final String SPLIT_MARK = "!";

	private final MockServerConfiguration mockServiceProperties;

	public MockServerStarter(final MockServerConfiguration mockServiceProperties) {

		this.mockServiceProperties = mockServiceProperties;
	}

	public void startMocks() {

		if (!mockServiceProperties.getServices().isEmpty()) {

			mockServiceProperties.getServices().forEach((s, mockProperties) -> {
				log.info("Starting mock service [{}]", s);
				new WireMockServer(buildMockProperties(mockProperties)).start();
			});

		}

	}

	private WireMockConfiguration buildMockProperties(final MockProperties mockProperties) {

		return WireMockConfiguration.options()
									.usingFilesUnderClasspath(mockProperties.getResourcesPath())
									.fileSource(new ClasspathFileSource(getPathResources(mockProperties.getResourcesPath())))
									.extensions(new ResponseTemplateTransformer(true))
									.port(mockProperties.getPort());
	}

	/**
	 * This method allows to get the path of the wiremock resources, allowing the jar at spring boot to find the resource folder more
	 * specifically the wiremock folder resources
	 *
	 * @return Path Resources Wiremock
	 */
	private String getPathResources(final String folderMock) {

		final URL url = getClass().getClassLoader().getResource(folderMock);
		String pathStubs = folderMock;

		if (nonNull(url)) {

			final String[] arrayPartitionPath = url.toExternalForm().split(SPLIT_MARK);

			if (arrayPartitionPath.length == 3) {

				final String pathResourcesMock = arrayPartitionPath[1] + arrayPartitionPath[2];
				pathStubs = (pathResourcesMock).substring(1);
			}
		}

		return pathStubs;
	}
}
