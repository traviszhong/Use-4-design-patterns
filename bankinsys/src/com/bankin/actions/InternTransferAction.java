package com.bankin.actions;

import com.bankin.service.ImplTransferPrechecker;
import com.bankin.service.TransferPrechecker;
import com.opensymphony.xwork2.ActionSupport;

public class InternTransferAction extends ActionSupport {

	private String username;
	private double balance;
	private TransferPrechecker tp;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		tp = new ImplTransferPrechecker();
		balance = tp.checkBalance(username);
		return SUCCESS;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
