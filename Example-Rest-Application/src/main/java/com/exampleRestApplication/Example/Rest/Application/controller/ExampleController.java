package com.exampleRestApplication.Example.Rest.Application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@GetMapping("/")
	public String homePage() {
		return "Home Page";
	}
}
