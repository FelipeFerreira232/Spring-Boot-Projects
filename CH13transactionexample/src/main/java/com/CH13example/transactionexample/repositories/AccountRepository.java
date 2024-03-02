package com.CH13example.transactionexample.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.CH13example.transactionexample.model.Account;

@Repository
public class AccountRepository {
	JdbcTemplate jdbc;

	public AccountRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	
	public List<Account> findAllAccounts(){
		return jdbc.query("select * from account;", new AccountRowMapper());
	}
	
	public void changeAmount(BigDecimal amount, int id) {
		jdbc.update("update account set amount = ? where id = ?;", amount, id);
	}
	
	public Account findById(int id) {
		return jdbc.queryForObject("select * from account where id = ?;", new AccountRowMapper(), id);
	}
}
