package com.senior.test.litepaymentservice.usecase.payment;

import static com.senior.test.litepaymentservice.usecase.payment.PaymentValidator.isValidPaymentRequest;

import org.springframework.stereotype.Service;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.repository.PaymentOrder;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudMapper;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudProvider;
import com.senior.test.litepaymentservice.usecase.share.PaymentMapper;
import com.senior.test.litepaymentservice.usecase.share.PaymentNetworkProvider;
import com.senior.test.litepaymentservice.usecase.share.PaymentOrderRepository;
import com.senior.test.litepaymentservice.usecase.share.RepositoryMapper;
import com.senior.test.litepaymentservice.usecase.share.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class implementation to process the payment request.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentUseCaseImpl implements PaymentUseCase {

	private final AntiFraudProvider antifraudProvider;

	private final PaymentNetworkProvider paymentNetworkProvider;

	private final TransactionRepository transactionRepository;

	private final PaymentOrderRepository paymentOrderRepository;

	private final RepositoryMapper repositoryMapper;

	private final AntiFraudMapper antiFraudMapper;

	private final PaymentMapper paymentMapper;

	@Override public LitePaymentResponse execute(final LitePaymentRequest litePaymentRequest) {

		final var response = LitePaymentResponse.builder();
		if (isValidPaymentRequest(litePaymentRequest)) {
			final var transaction = saveTransactionInDatabase(litePaymentRequest);
			log.info("Transaction id: [{}] was saved in database with state [{}]", transaction.getId(), transaction.getState());
			if (!isAFraudulentOperation(litePaymentRequest, transaction, response)) {
				processPayment(litePaymentRequest, transaction, response);
			}
		}
		return response.build();
	}

	private Transaction saveTransactionInDatabase(final LitePaymentRequest litePaymentRequest) {

		return transactionRepository.save(repositoryMapper.toTransaction(litePaymentRequest,
																		 saveAllPaymentOrderInDatabase(litePaymentRequest)));
	}

	private PaymentOrder saveAllPaymentOrderInDatabase(final LitePaymentRequest litePaymentRequest) {

		return paymentOrderRepository.save(repositoryMapper.toPaymentOrder(litePaymentRequest));

	}

	private boolean isAFraudulentOperation(final LitePaymentRequest litePaymentRequest,
										   final Transaction transaction,
										   final LitePaymentResponse.LitePaymentResponseBuilder response) {

		var antiFraudResponse = antifraudProvider.validateOperation(antiFraudMapper.toAntiFraud(litePaymentRequest));

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

	private void processPayment(final LitePaymentRequest litePaymentRequest,
								final Transaction transaction,
								final LitePaymentResponse.LitePaymentResponseBuilder response) {

		var bankPaymentResponse = paymentNetworkProvider.doPayment(paymentMapper.toBank(litePaymentRequest, transaction.getId()));

		transaction.setNetworkResponse(bankPaymentResponse.getMessage());
		transaction.setState(bankPaymentResponse.getResponseCode().getTransactionState());
		transaction.setNetworkCodeResponse(bankPaymentResponse.getResponseCode().getResponseCode());
		transactionRepository.save(transaction);
		log.info("Transaction id: [{}] was saved in database with state [{}]", transaction.getId(), transaction.getState());

		paymentMapper.toLitePayment(bankPaymentResponse, transaction.getTransactionType(), response);
	}

}


