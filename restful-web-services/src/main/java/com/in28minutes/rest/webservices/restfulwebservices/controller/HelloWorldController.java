package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.HelloWorld.HelloWorld;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	

	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World");
	}
	
	@GetMapping(path="/hello-world-pathvariable/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld("Hello World, " + name);
	}
	
	@GetMapping(path="/hello-world-international")
	public String helloWorldInternational() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		
		//en - Good Morning
		//fr - Bonjour
		//etc
	}
}
