package com.senior.test.litepaymentservice.infrastructure.ports.out.antifraudservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;

@FeignClient(name = "antifraud", url = "${services.antifraud.url}")
public interface AntiFraudServiceFeingClient {

	@PostMapping(value = "/validate-operation", consumes = "application/json")
	AntiFraudResponse validateOperation(final AntiFraudRequest antiFraudRequest);

}
