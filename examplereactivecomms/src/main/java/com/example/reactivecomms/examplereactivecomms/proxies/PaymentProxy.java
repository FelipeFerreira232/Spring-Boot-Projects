package com.example.reactivecomms.examplereactivecomms.proxies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.reactivecomms.examplereactivecomms.model.Payment;

import reactor.core.publisher.Mono;

@Component
public class PaymentProxy {
	
	private final WebClient webClient;
	
	@Value("${name.service.url}")
	private String url;
	
	

	public PaymentProxy(WebClient webClient) {
		super();
		this.webClient = webClient;
	}
	
	
	public Mono<Payment> createPayment(String requestID, Payment payment){
		return webClient.post()
					.uri(url+"/payment")
					.header("RequestID", requestID)
					.body(Mono.just(payment), Payment.class)
					.retrieve()
					.bodyToMono(Payment.class);
	}
}
