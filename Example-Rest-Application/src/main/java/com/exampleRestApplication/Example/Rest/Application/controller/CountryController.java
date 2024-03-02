package com.exampleRestApplication.Example.Rest.Application.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleRestApplication.Example.Rest.Application.model.Country;

@RestController
public class CountryController {
	
	@GetMapping("/france")
	public Country france() {
		return Country.of("France", 23);
	}
	
	@GetMapping("/all")
	public List<Country> countries() {
	Country c1 = Country.of("France", 67);
	Country c2 = Country.of("Spain", 47);
	return List.of(c1,c2);
	}
	
	@GetMapping("/france2")
	public ResponseEntity<Country> france2(){
		Country c = Country.of("France", 23);
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("Continent", "Europe")
				.header("Capital","Paris")
				.header("Favorite_Food","Cheese and Wine")
				.body(c);
	}
}
