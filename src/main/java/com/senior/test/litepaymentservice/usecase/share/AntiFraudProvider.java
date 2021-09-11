package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;

/**
 * Defines the operations provided by the anti fraud service.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
public interface AntiFraudProvider {

	AntiFraudResponse validateOperation(final AntiFraudRequest antiFraudRequest);

}
