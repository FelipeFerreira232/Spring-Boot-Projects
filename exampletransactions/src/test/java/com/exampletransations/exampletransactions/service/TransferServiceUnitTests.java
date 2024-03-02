package com.exampletransations.exampletransactions.service;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.exampletransations.exampletransactions.model.Account;
import com.exampletransations.exampletransactions.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {

	@Test
	@DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
	public void tranferMoneyHappyFlow() {
		// We feed the method arguments plus mock any dependency

		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(BigDecimal.valueOf(1000));

		Account receiver = new Account();
		receiver.setId(2);
		receiver.setAmount(BigDecimal.valueOf(1000));

		AccountRepository repository = mock(AccountRepository.class);
		AccountService service = new AccountService(repository);

		given(repository.findById(sender.getId())).willReturn(sender);

		given(repository.findById(receiver.getId())).willReturn(receiver);

		service.transferMoney(sender.getId(), receiver.getId(), BigDecimal.valueOf(100));

		verify(repository).changeAmount(1, BigDecimal.valueOf(900));

		verify(repository).changeAmount(2, BigDecimal.valueOf(1100));
	}
}
