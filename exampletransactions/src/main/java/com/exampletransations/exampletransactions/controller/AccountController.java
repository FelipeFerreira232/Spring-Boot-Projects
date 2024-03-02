package com.exampletransations.exampletransactions.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampletransations.exampletransactions.dto.TransferRequest;
import com.exampletransations.exampletransactions.model.Account;
import com.exampletransations.exampletransactions.service.AccountService;

@RestController
public class AccountController {

	private final AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}

	@PostMapping("/account")
	public void moneyTransfer(@RequestBody TransferRequest transfer) {
		service.transferMoney(transfer.getSenderId(), transfer.getReceiverId(), transfer.getAmount());
	}
	
	@GetMapping("/account")
	public List<Account> getAllAccounts(){
		return service.getAllAccounts();
	}
}
