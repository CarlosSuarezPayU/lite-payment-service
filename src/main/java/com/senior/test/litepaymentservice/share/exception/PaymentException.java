package com.senior.test.litepaymentservice.share.exception;

public class PaymentException extends RuntimeException {

	private static final long serialVersionUID = 4804944264789966124L;

	public PaymentException(final String message) {

		super(message);
	}
}
