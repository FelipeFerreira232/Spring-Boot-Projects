package com.exampleexceptionHandling.service;

import org.springframework.stereotype.Service;

import com.exampleexceptionHandling.exception.NotEnoughMoneyException;
import com.exampleexceptionHandling.model.PaymentDetails;

@Service
public class PaymentService {
	public PaymentDetails makePayment() {
		throw new NotEnoughMoneyException();
	}
}
