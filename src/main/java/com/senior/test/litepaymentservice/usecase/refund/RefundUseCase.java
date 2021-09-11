package com.senior.test.litepaymentservice.usecase.refund;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response.LiteRefundResponse;

public interface RefundUseCase {

	LiteRefundResponse execute(final LiteRefundRequest liteRefundRequest);

}
