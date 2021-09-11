package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response.LiteRefundResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;

public interface AntiFraudMapper {

	AntiFraudRequest toAntiFraud(final LitePaymentRequest litePaymentRequest);

	void toLiteResponse(final AntiFraudResponse antiFraudResponse,
						final Transaction transaction,
						final LitePaymentResponse.LitePaymentResponseBuilder response);

	AntiFraudRequest toAntiFraud(final LiteRefundRequest LiteRefundRequest);

	void toLiteResponse(final AntiFraudResponse antiFraudResponse,
						final Transaction transaction,
						final LiteRefundResponse.LiteRefundResponseBuilder response);

}
