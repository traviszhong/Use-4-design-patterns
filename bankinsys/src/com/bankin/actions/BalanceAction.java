package com.bankin.actions;

import org.apache.struts2.ServletActionContext;

import com.bankin.service.BalanceChecker;
import com.bankin.service.ImplBalanceChecker;
import com.opensymphony.xwork2.ActionSupport;

public class BalanceAction extends ActionSupport {

	private String username;
	private String balance;
	private BalanceChecker bc;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		bc = new ImplBalanceChecker();
		this.setBalance(Double.toString(bc.checkBalance(username)));
		return SUCCESS;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

}
