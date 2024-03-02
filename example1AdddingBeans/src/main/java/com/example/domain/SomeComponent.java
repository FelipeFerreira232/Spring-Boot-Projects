package com.example.domain;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SomeComponent {
	private String hope = "I want to live and still be hopefull.";
	public String getHope() {
		return hope;
	}
	
	@PostConstruct
	public void prayForHope() {
		System.out.println(getHope());
	}
}
