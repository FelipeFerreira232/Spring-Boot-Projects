package com.example.usingresttemplate.usingresttemplate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.usingresttemplate.usingresttemplate.model.Payment;
import com.example.usingresttemplate.usingresttemplate.proxies.PaymentProxy;

@RestController
public class PaymentController {

	private final PaymentProxy proxy;

	public PaymentController(PaymentProxy proxy) {
		super();
		this.proxy = proxy;
	}
	
	@PostMapping("/payment")
	public void createPayment(@RequestBody Payment payment) {
		proxy.createPayment(payment);
	}
}
