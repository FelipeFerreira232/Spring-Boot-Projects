package com.example.reactivecomms.examplereactivecomms.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactivecomms.examplereactivecomms.model.Payment;
import com.example.reactivecomms.examplereactivecomms.proxies.PaymentProxy;

import reactor.core.publisher.Mono;

@RestController
public class PaymentController {
	
	private final PaymentProxy paymentProxy;
	
	public PaymentController(PaymentProxy paymentsProxy) {
		this.paymentProxy = paymentsProxy;
	}
	
	@PostMapping("/payment")
	public Mono<Payment> createPayment(@RequestBody Payment payment) {
		//
		String requestId = UUID.randomUUID().toString();
		return paymentProxy.createPayment(requestId, payment);
	}
}
