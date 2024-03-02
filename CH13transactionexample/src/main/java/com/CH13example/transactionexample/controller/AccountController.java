package com.CH13example.transactionexample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CH13example.transactionexample.model.Account;
import com.CH13example.transactionexample.model.Transaction;
import com.CH13example.transactionexample.service.TransferService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	private final TransferService service;
	

	public AccountController(TransferService service) {
		super();
		this.service = service;
	}



	//TO BE IMPLEMENTED
	@GetMapping
	public List<Account> findAllAccounts(){
		return service.getAllAccounts();
	}
	
	@PostMapping
	public List<Account> moneyTransfer(@RequestBody Transaction transaction){
		service.TransferMoney(transaction);
		return findAllAccounts();
	}
}
