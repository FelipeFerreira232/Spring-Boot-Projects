package com.CH14example.springdata.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.CH14example.springdata.exception.AccountNotFoundException;
import com.CH14example.springdata.model.Account;
import com.CH14example.springdata.model.Transaction;
import com.CH14example.springdata.repositories.AccountRepository;

@Service
public class TransferService {
	private final AccountRepository repository;

	public TransferService(AccountRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Account> getAllAccounts(){
		return repository.findAllAccounts();
	}
	
	public List<Account> getAllAccountsByName(String name){
		return repository.findAccountsByName(name);
	}
	
	@Transactional
	public void TransferMoney(@RequestBody Transaction transaction) {
		int senderId  = transaction.getSenderId();
		int receiverId = transaction.getReceiverId();
		
		Account sender = repository.findById(senderId)
				.orElseThrow(() -> new AccountNotFoundException());
		Account receiver = repository.findById(receiverId)
				.orElseThrow(() -> new AccountNotFoundException());
		
		BigDecimal newSenderAmount = sender.getAmount().subtract(transaction.getAmount());
		BigDecimal newReceiverAmount = receiver.getAmount().add(transaction.getAmount());
		
		repository.changeAmount(newSenderAmount, senderId);
		repository.changeAmount(newReceiverAmount, receiverId);
	}
}


