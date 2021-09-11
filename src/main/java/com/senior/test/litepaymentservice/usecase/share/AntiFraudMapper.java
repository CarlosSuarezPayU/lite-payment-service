package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;

public interface AntiFraudMapper {

	AntiFraudRequest toAntiFraud(final LitePaymentRequest litePaymentRequest);

	void toLiteResponse(final AntiFraudResponse antiFraudResponse,
						final Transaction transaction,
						final LitePaymentResponse.LitePaymentResponseBuilder response);

}
