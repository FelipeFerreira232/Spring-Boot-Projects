package com.exampletransations.exampletransactions.service;

import java.math.BigDecimal;	
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.exampletransations.exampletransactions.model.Account;
import com.exampletransations.exampletransactions.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository repository;

	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void transferMoney(int senderId, int receiverId, BigDecimal amount) {
		Account sender = repository.findById(senderId);
		Account receiver = repository.findById(receiverId);

		BigDecimal newReceiverAmount = receiver.getAmount().add(amount);
		BigDecimal newSenderAmount = sender.getAmount().subtract(amount);

		repository.changeAmount(senderId, newSenderAmount);
		repository.changeAmount(receiverId, newReceiverAmount);
	}

	public List<Account> getAllAccounts() {
		return repository.findAll();
	}
}
