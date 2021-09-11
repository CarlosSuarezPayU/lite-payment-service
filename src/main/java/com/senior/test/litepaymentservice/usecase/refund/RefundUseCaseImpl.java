package com.senior.test.litepaymentservice.usecase.refund;

import org.springframework.stereotype.Service;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response.LiteRefundResponse;
import com.senior.test.litepaymentservice.share.exception.PaymentException;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;
import com.senior.test.litepaymentservice.usecase.share.RepositoryMapper;
import com.senior.test.litepaymentservice.usecase.share.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefundUseCaseImpl implements RefundUseCase {

	private TransactionRepository transactionRepository;

	private RepositoryMapper repositoryMapper;

	@Override public LiteRefundResponse execute(final LiteRefundRequest liteRefundRequest) {
		final var parentTransaction = getParentTransactionFromDatabase(liteRefundRequest.getTransactionParentId());

		return null;
	}

	private Transaction getParentTransactionFromDatabase(final String parentTransactionId) {

		return transactionRepository.findById(parentTransactionId).orElseThrow(
				() -> new PaymentException(String.format("The transaction id [{%s}] not exists in our database.", parentTransactionId)));

	}

	private Transaction createRefundTransaction(final Transaction parent){
			return transactionRepository.save(repositoryMapper.toTransactionFromParent(parent));
	}
}
