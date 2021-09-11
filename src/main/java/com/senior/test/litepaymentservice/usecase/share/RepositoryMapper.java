package com.senior.test.litepaymentservice.usecase.share;

import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.share.model.repository.PaymentOrder;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;

/**
 * Mapper definition of repository entities to controller request classes.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
public interface RepositoryMapper {

	PaymentOrder toPaymentOrder(final LitePaymentRequest litePaymentRequest);

	Transaction toTransaction(final LitePaymentRequest litePaymentRequest, final PaymentOrder paymentOrder);

	Transaction toTransactionFromParent(final Transaction parent);

}
