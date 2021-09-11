package com.senior.test.litepaymentservice.share.util;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.CreditCard;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.Payer;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.antifraud.AntiFraudResponse;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudCreditCard;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudPayer;
import com.senior.test.litepaymentservice.share.model.antifraud.request.AntiFraudRequest;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;
import com.senior.test.litepaymentservice.usecase.share.AntiFraudMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AntiFraudMapperImpl implements AntiFraudMapper {

	@Override public AntiFraudRequest toAntiFraud(final LitePaymentRequest litePaymentRequest) {

		return AntiFraudRequest.builder()
							   .withPayer(buildAntiFraudPayer(litePaymentRequest.getPayer()))
							   .withCreditCard(buildAntiFraudCreditCard(litePaymentRequest.getCreditCard()))
							   .build();
	}

	@Override public void toLiteResponse(final AntiFraudResponse antiFraudResponse,
										 final Transaction transaction,
										 final LitePaymentResponse.LitePaymentResponseBuilder response) {

		response.withTransactionId(transaction.getId())
				.withTransactionType(transaction.getTransactionType())
				.withTransactionState(TransactionState.DECLINED)
				.withResponseCode(String.valueOf(antiFraudResponse.isFraud()))
				.withResponseMessage(antiFraudResponse.getMessage())
				.withTransactionCreation(transaction.getCreationDate());
	}

	private AntiFraudCreditCard buildAntiFraudCreditCard(final CreditCard paymentRequestCreditCard) {

		return AntiFraudCreditCard.builder()
								  .withCreditCardNumber(paymentRequestCreditCard.getPanNumber())
								  .withSecurityCode(paymentRequestCreditCard.getCvv2())
								  .withExpirationDate(paymentRequestCreditCard.getExpirationDate())
								  .withName(paymentRequestCreditCard.getName())
								  .build();
	}

	private AntiFraudPayer buildAntiFraudPayer(final Payer paymentRequestPayer) {

		return AntiFraudPayer.builder()
							 .withFullName(paymentRequestPayer.getFullName())
							 .withIdentification(paymentRequestPayer.getIdentification())
							 .withIdentificationType(paymentRequestPayer.getIdentificationType())
							 .build();
	}
}
