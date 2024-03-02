package com.CH14example.springdata.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Account {
	@Id
	private int id;
	private String name;
	private BigDecimal amount;
	
	public Account() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
