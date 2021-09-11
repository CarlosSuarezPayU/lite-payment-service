package com.senior.test.litepaymentservice.infrastructure.ports.out.antifraudservice;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AntiFraudProviderImpl implements AntiFraudProvider {

	private final AntiFraudServiceFeingClient antiFraudServiceFeingClient;

	@Override
	public AntiFraudResponse validateOperation(final AntiFraudRequest antiFraudRequest) {

		return antiFraudServiceFeingClient.validateOperation(antiFraudRequest);
	}

}
