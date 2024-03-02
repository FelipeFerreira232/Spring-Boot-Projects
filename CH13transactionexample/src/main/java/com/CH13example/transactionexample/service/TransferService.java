package com.CH13example.transactionexample.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.CH13example.transactionexample.model.Account;
import com.CH13example.transactionexample.model.Transaction;
import com.CH13example.transactionexample.repositories.AccountRepository;

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
	
	@Transactional
	public void TransferMoney(@RequestBody Transaction transaction) {
		int senderId  = transaction.getSenderId();
		int receiverId = transaction.getReceiverId();
		
		Account sender = repository.findById(senderId);
		Account receiver = repository.findById(receiverId);
		
		BigDecimal newSenderAmount = sender.getAmount().subtract(transaction.getAmount());
		BigDecimal newReceiverAmount = receiver.getAmount().add(transaction.getAmount());
		
		repository.changeAmount(newSenderAmount, senderId);
		repository.changeAmount(newReceiverAmount, receiverId);
	}
}


