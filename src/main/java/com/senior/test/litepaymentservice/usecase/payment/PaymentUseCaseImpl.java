package com.senior.test.litepaymentservice.usecase.payment;

import static com.senior.test.litepaymentservice.usecase.payment.PaymentValidator.isValidPaymentRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
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

		final var transaction = saveTransactionInDatabase(litePaymentRequest);
		final var response = LitePaymentResponse.builder();
		if (isValidPaymentRequest(litePaymentRequest, response)) {
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

		if(antiFraudResponse.isFraud()){
			transaction.setState(TransactionState.DECLINED);
			antiFraudMapper.toLiteResponse(antiFraudResponse, transaction, response);
		}
		transactionRepository.save(transaction);

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

		paymentMapper.toLitePayment(bankPaymentResponse, transaction.getTransactionType(), response);
	}

}


