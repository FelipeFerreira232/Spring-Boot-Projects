package com.example.exampledatabase.exampledatabase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exampledatabase.exampledatabase.model.Purchase;
import com.example.exampledatabase.exampledatabase.repositories.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	private final PurchaseRepository repository;

	public PurchaseController(PurchaseRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	@PostMapping
	public void storePurchase(@RequestBody Purchase purchase) {
		repository.storePurchase(purchase);
	}
	
	@GetMapping
	public List<Purchase> findAllPurchase(){
		return repository.findAllPurchase();
	}
}
