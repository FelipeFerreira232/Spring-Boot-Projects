package com.exampletransations.exampletransactions.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Account {
	@Id
	private int id;
	private String name;
	private BigDecimal amount;

	public Account() {

	}

	public Account(int id, String name, BigDecimal amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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
