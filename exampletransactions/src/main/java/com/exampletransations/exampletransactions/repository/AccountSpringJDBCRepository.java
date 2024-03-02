package com.exampletransations.exampletransactions.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.exampletransations.exampletransactions.model.Account;

public interface AccountSpringJDBCRepository  extends CrudRepository<Account, Integer> {
	
	@Query("select * from account where name = :name")
	List<Account> findAccountsByName(String name);
	
	@Modifying
	@Query("update account set amount = :amount where id = :id")
	public void changeAmount(int id, BigDecimal amount);
	
	@Query("select * from account")
	public List<Account> getAllAccounts();
}
