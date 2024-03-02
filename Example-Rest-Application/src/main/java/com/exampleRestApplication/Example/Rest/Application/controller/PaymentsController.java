package com.exampleRestApplication.Example.Rest.Application.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.exampleRestApplication.Example.Rest.Application.model.Payment;
import com.exampleRestApplication.Example.Rest.Application.proxies.PaymentsProxy;

@RestController
public class PaymentsController {
	
	private final PaymentsProxy proxy;
	private static Logger logger = Logger.getLogger(PaymentController.class.getClass().getName());
	
	public PaymentsController(PaymentsProxy proxy) {
		this.proxy = proxy;
	}
	
	
	
	
	
	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment) {
		String requestId = UUID.randomUUID().toString();
		return proxy.createPayment(requestId, payment);
	}
	
	@PostMapping("/payments")
	public ResponseEntity<Payment> payments2(@RequestHeader String requestId,
											@RequestBody Payment payment){
		logger.info("Payment received: \nRequest ID: " + requestId +"\nPayment Amount: " + payment.getAmount());
		payment.setId(UUID.randomUUID().toString());
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("requestId", requestId)
				.body(payment);
	}
}
