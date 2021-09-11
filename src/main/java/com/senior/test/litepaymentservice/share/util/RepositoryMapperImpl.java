package com.senior.test.litepaymentservice.share.util;

import static com.senior.test.litepaymentservice.share.util.LitePaymentUtil.maskCreditCardNumber;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.payment.response.BankPaymentResponse;
import com.senior.test.litepaymentservice.share.model.repository.CreditCard;
import com.senior.test.litepaymentservice.share.model.repository.Payer;
import com.senior.test.litepaymentservice.share.model.repository.PaymentOrder;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;
import com.senior.test.litepaymentservice.usecase.share.RepositoryMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RepositoryMapperImpl implements RepositoryMapper {

	@Override public PaymentOrder toPaymentOrder(final LitePaymentRequest litePaymentRequest) {

		return PaymentOrder.builder()
						   .withPayer(buildPayer(litePaymentRequest))
						   .withCard(buildCreditCard(litePaymentRequest))
						   .build();
	}

	@Override public Transaction toTransaction(final LitePaymentRequest litePaymentRequest,
											   final PaymentOrder paymentOrder) {

		return Transaction.builder()
						  .withTransactionType(litePaymentRequest.getTransactionType())
						  .withAmount(litePaymentRequest.getAmount().getTotal())
						  .withState(TransactionState.CREATED)
						  .withCurrencyValue(litePaymentRequest.getAmount().getCurrency())
						  .withPaymentOrder(paymentOrder)
						  .build();
	}

	private Payer buildPayer(final LitePaymentRequest litePaymentRequest){
		return Payer.builder()
					.withFullName(litePaymentRequest.getPayer().getFullName())
					.withIdentification(litePaymentRequest.getPayer().getIdentification())
					.withIdentificationType(litePaymentRequest.getPayer().getIdentificationType())
					.withEmail(litePaymentRequest.getPayer().getEmail())
					.withAddress(litePaymentRequest.getPayer().getAddress())
					.withPhone(litePaymentRequest.getPayer().getPhone())
					.build();
	}

	private CreditCard buildCreditCard(final LitePaymentRequest litePaymentRequest){
		return CreditCard.builder()
						 .withPanNumber(maskCreditCardNumber(litePaymentRequest.getCreditCard().getPanNumber()))
						 .withFranchiseCard(litePaymentRequest.getCreditCard().getFranchiseCard())
						 .build();
	}


}

