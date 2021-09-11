package com.senior.test.litepaymentservice.infrastructure.ports.out.antifraudservice;

import static com.senior.test.litepaymentservice.share.constant.LitePaymentConstants.ANTI_FRAUD_NAME;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudProvider;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AntiFraudProviderImpl implements AntiFraudProvider {

	private final AntiFraudServiceFeingClient antiFraudServiceFeingClient;

	@Override
	@CircuitBreaker(name = ANTI_FRAUD_NAME, fallbackMethod = "validateOperationFallback")
	public AntiFraudResponse validateOperation(final AntiFraudRequest antiFraudRequest) {

		return antiFraudServiceFeingClient.validateOperation(antiFraudRequest);
	}

	private AntiFraudResponse validateOperationFallback(final AntiFraudRequest antiFraudRequest,
														final Throwable throwable){

		return AntiFraudResponse.builder()
								.withMessage(String.format("Refund fallback exception [{%s}]", throwable.getMessage()))
								.build();

	}

}
