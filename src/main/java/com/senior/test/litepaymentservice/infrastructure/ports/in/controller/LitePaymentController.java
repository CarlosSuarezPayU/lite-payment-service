package com.senior.test.litepaymentservice.infrastructure.ports.in.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.request.LitePaymentRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.payment.response.LitePaymentResponse;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.request.LiteRefundRequest;
import com.senior.test.litepaymentservice.infrastructure.ports.in.controller.model.refund.response.LiteRefundResponse;
import com.senior.test.litepaymentservice.usecase.payment.PaymentUseCase;
import com.senior.test.litepaymentservice.usecase.refund.RefundUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/lite")
@RequiredArgsConstructor
public class LitePaymentController {

	private final PaymentUseCase paymentUseCase;

	private final RefundUseCase refundUseCase;

	@PostMapping("/payment")
	public ResponseEntity<LitePaymentResponse> createLitePayment(@Valid @RequestBody final LitePaymentRequest litePaymentRequest) {

		return new ResponseEntity<>(paymentUseCase.execute(litePaymentRequest), HttpStatus.ACCEPTED);
	}

	@PostMapping("/refund")
	public ResponseEntity<LiteRefundResponse> createLitePayment(@Valid @RequestBody final LiteRefundRequest liteRefundRequest) {

		return new ResponseEntity<>(refundUseCase.execute(liteRefundRequest), HttpStatus.ACCEPTED);
	}

}
