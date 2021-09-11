package com.senior.test.litepaymentservice.infrastructure.ports.in.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.senior.test.litepaymentservice.share.exception.PaymentException;

@ControllerAdvice
public class RestControllerHandlerError {

	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<String> handleBaproFileNotFoundException(PaymentException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.ACCEPTED);

	}
}
