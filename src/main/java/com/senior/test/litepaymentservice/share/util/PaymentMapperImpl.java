package com.senior.test.litepaymentservice.share.util;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.Amount;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.CreditCard;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.share.model.TransactionType;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentAmount;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentCreditCard;
import com.senior.test.litepaymentservice.share.model.payment.request.BankPaymentRequest;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.refund.request.BankRefundRequest;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;
import com.senior.test.litepaymentservice.usecase.share.PaymentMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMapperImpl implements PaymentMapper {

	@Override public BankPaymentRequest toBank(final LitePaymentRequest litePaymentRequest,
											   final String transactionId) {

		return BankPaymentRequest.builder()
								 .withTransactionId(transactionId)
								 .withPayerIdentificationId(litePaymentRequest.getPayer().getIdentification())
								 .withCard(buildBankPaymentCreditCard(litePaymentRequest.getCreditCard()))
								 .withAmount(buildBankPaymentAmount(litePaymentRequest.getAmount()))
								 .build();
	}

	@Override public void toLitePayment(final BankPaymentResponse bankPaymentResponse,
										final TransactionType transactionType,
										final LitePaymentResponse.LitePaymentResponseBuilder response) {

		response
				.withTransactionId(bankPaymentResponse.getTransactionId())
				.withTransactionType(transactionType)
				.withTransactionState(bankPaymentResponse.getResponseCode().getTransactionState())
				.withResponseCode(bankPaymentResponse.getResponseCode().getResponseCode())
				.withResponseMessage(bankPaymentResponse.getMessage())
				.withTransactionCreation(bankPaymentResponse.getCreationDate());
	}

	@Override public BankRefundRequest toBankRefundRequest(final Transaction transaction) {

		return BankRefundRequest.builder()
								.withTransactionId(transaction.getId())
								.withAmount(transaction.getAmount())
								.build();
	}

	private BankPaymentCreditCard buildBankPaymentCreditCard(final CreditCard creditCard) {

		return BankPaymentCreditCard.builder()
									.withPanNumber(creditCard.getPanNumber())
									.withExpirationDate(creditCard.getExpirationDate())
									.withCvv2(creditCard.getCvv2())
									.withName(creditCard.getName())
									.build();
	}

	private BankPaymentAmount buildBankPaymentAmount(final Amount amount) {

		return BankPaymentAmount.builder()
								.withValue(amount.getValue())
								.withTax(amount.getTax())
								.withTotal(amount.getTotal())
								.withCurrency(amount.getCurrency())
								.build();
	}
}
