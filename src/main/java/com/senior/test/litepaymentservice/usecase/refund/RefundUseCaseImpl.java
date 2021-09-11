package com.senior.test.litepaymentservice.usecase.refund;

import static com.senior.test.litepaymentservice.usecase.refund.RefundValidator.isValidRefundRequest;

import org.springframework.stereotype.Service;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response.LiteRefundResponse;
import com.senior.test.litepaymentservice.share.exception.PaymentException;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudMapper;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudProvider;
import com.senior.test.litepaymentservice.usecase.share.PaymentMapper;
import com.senior.test.litepaymentservice.usecase.share.PaymentNetworkProvider;
import com.senior.test.litepaymentservice.usecase.share.RepositoryMapper;
import com.senior.test.litepaymentservice.usecase.share.TransactionRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Class implementation to process the refund request.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Slf4j
@Service
public class RefundUseCaseImpl implements RefundUseCase {

	private PaymentNetworkProvider paymentNetworkProvider;

	private AntiFraudProvider antiFraudProvider;

	private TransactionRepository transactionRepository;

	private RepositoryMapper repositoryMapper;

	private AntiFraudMapper antiFraudMapper;

	private PaymentMapper paymentMapper;

	public RefundUseCaseImpl(final PaymentNetworkProvider paymentNetworkProvider,
							 final AntiFraudProvider antiFraudProvider,
							 final TransactionRepository transactionRepository,
							 final RepositoryMapper repositoryMapper,
							 final AntiFraudMapper antiFraudMapper, final PaymentMapper paymentMapper) {

		this.paymentNetworkProvider = paymentNetworkProvider;
		this.antiFraudProvider = antiFraudProvider;
		this.transactionRepository = transactionRepository;
		this.repositoryMapper = repositoryMapper;
		this.antiFraudMapper = antiFraudMapper;
		this.paymentMapper = paymentMapper;
	}

	@Override public LiteRefundResponse execute(final LiteRefundRequest liteRefundRequest) {

		final var response = LiteRefundResponse.builder();
		if (isValidRefundRequest(liteRefundRequest)) {
			final var transaction = createRefundTransaction(getParentTransactionFromDatabase(liteRefundRequest.getTransactionParentId()));
			log.info("Transaction id: [{}] was saved in database with state [{}]", transaction.getId(), transaction.getState());
			if (!isAFraudulentOperation(liteRefundRequest, transaction, response)) {
				processRefund(liteRefundRequest, transaction, response);
			}
		}
		return response.build();
	}

	private Transaction getParentTransactionFromDatabase(final String parentTransactionId) {

		final var parentTransaction = transactionRepository.findById(parentTransactionId);
		if (parentTransaction.isPresent()) {
			return parentTransaction.get();
		} else {
			throw new PaymentException(String.format("The transaction id [{%s}] not exists in our database.", parentTransactionId));
		}
	}

	private Transaction createRefundTransaction(final Transaction parent) {

		return transactionRepository.save(repositoryMapper.toTransactionFromParent(parent));
	}

	private boolean isAFraudulentOperation(final LiteRefundRequest liteRefundRequest,
										   final Transaction transaction,
										   final LiteRefundResponse.LiteRefundResponseBuilder response) {

		var antiFraudResponse = antiFraudProvider.validateOperation(antiFraudMapper.toAntiFraud(liteRefundRequest));

		transaction.setAntiFraudResponse(String.valueOf(antiFraudResponse.isFraud()));
		transaction.setMessage(antiFraudResponse.getMessage());

		if (antiFraudResponse.isFraud()) {
			transaction.setState(TransactionState.DECLINED);
			antiFraudMapper.toLiteResponse(antiFraudResponse, transaction, response);
		}
		transactionRepository.save(transaction);
		log.info("Transaction id: [{}] was saved in database with state [{}]", transaction.getId(), transaction.getState());

		return antiFraudResponse.isFraud();
	}

	private void processRefund(final LiteRefundRequest liteRefundRequest,
							   final Transaction transaction,
							   final LiteRefundResponse.LiteRefundResponseBuilder response) {

		var bankRefundResponse = paymentNetworkProvider.doRefund(paymentMapper.toBank(liteRefundRequest, transaction));

		transaction.setNetworkResponse(bankRefundResponse.getMessage());
		transaction.setState(bankRefundResponse.getResponseCode().getTransactionState());
		transaction.setNetworkCodeResponse(bankRefundResponse.getResponseCode().getResponseCode());
		transactionRepository.save(transaction);
		log.info("Transaction id: [{}] was saved in database with state [{}]", transaction.getId(), transaction.getState());

		paymentMapper.toLitePayment(bankRefundResponse, transaction.getTransactionType(), response);
	}
}
