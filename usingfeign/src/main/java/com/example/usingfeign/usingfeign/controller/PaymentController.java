package com.example.usingfeign.usingfeign.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.usingfeign.usingfeign.model.Payment;
import com.example.usingfeign.usingfeign.proxies.PaymentProxy;

@RestController
public class PaymentController {
	
	private final PaymentProxy proxy;
	
	public PaymentController(PaymentProxy proxy) {
		this.proxy = proxy;
	}
	
	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment){
		String requestId = UUID.randomUUID().toString();
		return proxy.createPayment(requestId, payment);
	}
}
