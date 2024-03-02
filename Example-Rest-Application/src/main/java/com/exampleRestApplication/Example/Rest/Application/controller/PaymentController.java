package com.exampleRestApplication.Example.Rest.Application.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampleRestApplication.Example.Rest.Application.exception.ErrorDetails;
import com.exampleRestApplication.Example.Rest.Application.exception.NotEnoughMoneyException;
import com.exampleRestApplication.Example.Rest.Application.model.PaymentDetails;
import com.exampleRestApplication.Example.Rest.Application.service.PaymentService;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	private PaymentService service;

	public PaymentController(PaymentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/payment")
	public ResponseEntity<?> makePayment(@RequestBody PaymentDetails details){
		logger.info("Payment Details\nAmount: " + details.getAmount());
		return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.header("Success", "dale")
					.body(details);
	}
}
