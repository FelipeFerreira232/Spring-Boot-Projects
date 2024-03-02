package com.example.endpoincomms.endpointcommunication.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoincomms.endpointcommunication.model.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private final Logger logger = Logger.getLogger(PaymentController.class.getName());

	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestHeader String requestID,
												@RequestBody Payment payment){
		logger.info("\nReceived Payment Info:\nID: " + requestID + "\nAmount: " + payment.getAmount());
		
		payment.setId(requestID);
		
		return ResponseEntity
							.status(HttpStatus.ACCEPTED)
							.header("Request ID", requestID)
							.body(payment);
	}
}
