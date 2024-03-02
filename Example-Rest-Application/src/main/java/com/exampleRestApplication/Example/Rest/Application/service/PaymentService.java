package com.exampleRestApplication.Example.Rest.Application.service;

import org.springframework.stereotype.Component;

import com.exampleRestApplication.Example.Rest.Application.exception.NotEnoughMoneyException;
import com.exampleRestApplication.Example.Rest.Application.model.PaymentDetails;

@Component
public class PaymentService {
	public PaymentDetails processPayment() {
		throw new NotEnoughMoneyException();
	}
}
