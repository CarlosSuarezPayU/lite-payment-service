package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.share.model.repository.PaymentOrder;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;

public interface RepositoryMapper {

	PaymentOrder toPaymentOrder(final LitePaymentRequest litePaymentRequest);

	Transaction toTransaction(final LitePaymentRequest litePaymentRequest, final PaymentOrder paymentOrder);

	Transaction toTransactionFromParent(final Transaction parent);

}
