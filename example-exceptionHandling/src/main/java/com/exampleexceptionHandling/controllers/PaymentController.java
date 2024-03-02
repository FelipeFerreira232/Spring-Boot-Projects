package com.exampleexceptionHandling.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleexceptionHandling.model.PaymentDetails;
import com.exampleexceptionHandling.service.PaymentService;

@RestController
public class PaymentController {
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	@GetMapping("/payment")
	public ResponseEntity<PaymentDetails> makePayment() {
		PaymentDetails paymentDetails = paymentService.makePayment();
		return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(paymentDetails);
	}
}
