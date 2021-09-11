package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;

public interface AntiFraudProvider {

	AntiFraudResponse validateOperation(final AntiFraudRequest antiFraudRequest);

}
