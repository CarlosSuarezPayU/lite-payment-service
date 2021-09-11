package com.senior.test.litepaymentservice.infrastructure.ports.in.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.usecase.payment.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/lite")
public class LitePaymentController {

	private final PaymentUseCase paymentUseCase;

	public LitePaymentController(final PaymentUseCase paymentUseCase) {

		this.paymentUseCase = paymentUseCase;
	}

	@PostMapping("/payment")
	public ResponseEntity<LitePaymentResponse> createLitePayment(@Valid @RequestBody final LitePaymentRequest litePaymentRequest){
		return new ResponseEntity<>(paymentUseCase.execute(litePaymentRequest), HttpStatus.ACCEPTED);
	}



}
