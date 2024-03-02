package com.exampleexceptionHandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotEnoughMoneyAdviceController {

	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<ErrorDetails> notEnoughMoneyHandler(){
		ErrorDetails errorDetails = new ErrorDetails("Insuficient funds.");
		return ResponseEntity
				.badRequest()
				.body(errorDetails);
	}
}
