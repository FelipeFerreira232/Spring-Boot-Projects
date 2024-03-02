package com.CH14example.springdata.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CH14example.springdata.model.Account;
import com.CH14example.springdata.model.Transaction;
import com.CH14example.springdata.service.TransferService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	private final TransferService service;
	

	public AccountController(TransferService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public Iterable<Account> findAllAccountsByName(@RequestParam (required=false) String name){
		if(name == null)
			return service.getAllAccounts();
		else
			return service.getAllAccountsByName(name);
	}
	
	
	@PostMapping
	public Iterable<Account> moneyTransfer(@RequestBody Transaction transaction){
		service.TransferMoney(transaction);
		return service.getAllAccounts();
	}
}
