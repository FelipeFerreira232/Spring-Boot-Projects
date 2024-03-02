package com.exampletransations.exampletransactions.service;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exampletransations.exampletransactions.model.Account;
import com.exampletransations.exampletransactions.repository.AccountRepository;

import exampletransactions.AccountNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTests {

	@Mock
	AccountRepository repository;
	
	@InjectMocks
	private AccountService service;
	
	@Test
	@DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
	public void transferMoneyHappyFlow() {
		// We feed the method arguments plus mock any dependency

		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(BigDecimal.valueOf(1000));

		Account receiver = new Account();
		receiver.setId(2);
		receiver.setAmount(BigDecimal.valueOf(1000));

		given(repository.findById(sender.getId())).willReturn(sender);

		given(repository.findById(receiver.getId())).willReturn(receiver);

		service.transferMoney(sender.getId(), receiver.getId(), BigDecimal.valueOf(100));

		verify(repository).changeAmount(1, BigDecimal.valueOf(900));

		verify(repository).changeAmount(2, BigDecimal.valueOf(1100));
	}
	
	@Test
	public void moneyTransferDestinationAccountNotFoundFlow() {
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(BigDecimal.valueOf(1000));

		Account receiver = new Account();
		receiver.setId(2);
		receiver.setAmount(BigDecimal.valueOf(1000));
		
		given(repository.findById(sender.getId())).willReturn(sender);
		given(repository.findById(2).willReturn(Optional.empty()));
		
		Assertions.assertThrows(AccountNotFoundException.class, () -> service.transferMoney(1, 2, new BigDecimal(100)));	
		
		verify(repository, never()).changeAmount(anyInt(), any());
	}
}
