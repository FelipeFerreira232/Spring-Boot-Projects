package com.exampletransations.exampletransactions.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exampletransations.exampletransactions.model.Account;
import com.exampletransations.exampletransactions.model.AccountRowMapper;

@Repository
public class AccountRepository {

	JdbcTemplate jdbc;

	public AccountRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	public Account findById(int id) {
		String sql = "select * from account where id = ?";
		return jdbc.queryForObject(sql, new AccountRowMapper(), id);
	}
	
	public List<Account> findAll(){
		String sql = "select * from account";
		return jdbc.query(sql, new AccountRowMapper());
	}
	
	public void changeAmount(int id, BigDecimal amount) {
		String sql = "update account set amount = ? where id = ?";
		jdbc.update(sql, amount, id);
	}
}
