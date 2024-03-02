package com.CH14example.springdata.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.CH14example.springdata.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	@Query("select * from account where name = :name;")
	public List<Account> findAccountsByName(String name);
	
	@Query("select * from account;")
	public List<Account> findAllAccounts();
	
	@Query("select * from account where id = :id;")
	public Optional<Account> findById(int id);
	
	@Query("update account set amount = :amount where id = :id;")
	@Modifying
	public void changeAmount(BigDecimal amount, int id);
	
}
