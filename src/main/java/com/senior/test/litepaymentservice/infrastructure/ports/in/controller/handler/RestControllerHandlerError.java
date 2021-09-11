package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.share.exception.PaymentException;
import com.senior.test.litepaymentservice.share.model.TransactionState;

@ControllerAdvice
public class RestControllerHandlerError {

	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<LitePaymentResponse> handlePaymentException(PaymentException exception) {

		return new ResponseEntity<>(buildResponseError(exception.getMessage()), HttpStatus.ACCEPTED);

	}

	private LitePaymentResponse buildResponseError(final String errorMessage) {

		return LitePaymentResponse.builder()
								  .withTransactionState(TransactionState.ERROR)
								  .withResponseMessage(String.format("Transaction with error [{%s}].", errorMessage))
								  .build();
	}

}
