package com.senior.test.litepaymentservice.usecase.refund;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response.LiteRefundResponse;

/**
 * Class definition of the refund process.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
public interface RefundUseCase {

	LiteRefundResponse execute(final LiteRefundRequest liteRefundRequest);

}
