package com.example.usingresttemplate.usingresttemplate.proxies;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.usingresttemplate.usingresttemplate.model.Payment;

@Component
public class PaymentProxy {
	
	private final RestTemplate rest;
	private final Logger logger = Logger.getLogger(PaymentProxy.class.getName());
	
	@Value("${name.service.url}")
	private String paymentServiceUrl;
	
	public PaymentProxy(RestTemplate rest) {
		super();
		this.rest = rest;
	}



	public void createPayment(Payment payment) {
		String uri = paymentServiceUrl + "/payment";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("requestId", UUID.randomUUID().toString());
		
		HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
		
		ResponseEntity<Payment> response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
		Payment paymentResponse = response.getBody();
		logger.info("Response Payment:\n" + paymentResponse);
	}
}
