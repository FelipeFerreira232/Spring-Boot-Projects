package com.exampletransations.exampletransactions.dto;

import java.math.BigDecimal;

public class TransferRequest {

	private int senderId;
	private int receiverId;
	private BigDecimal amount;

	public TransferRequest(int senderId, int receiverId, BigDecimal amount) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
