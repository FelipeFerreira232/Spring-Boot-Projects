package com.example.usingfeign.usingfeign.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.usingfeign.usingfeign.model.Payment;

@FeignClient(name="payments", url="${name.service.url}")
public interface PaymentProxy {

@PostMapping("/payment")
public Payment createPayment(@RequestHeader String requestId,
					@RequestBody Payment payment);
}
