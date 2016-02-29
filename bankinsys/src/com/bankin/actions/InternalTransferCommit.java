package com.bankin.actions;

import com.bankin.service.ImplInternalTransferor;
import com.bankin.service.InternalTransferor;
import com.opensymphony.xwork2.ActionSupport;

public class InternalTransferCommit extends ActionSupport {

	private double amount;
	private String account_number;
	private String username;
	private InternalTransferor it;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean res;
		it = new ImplInternalTransferor();
		res = it.makeInternalTransfer(username, account_number, amount);
		if(res == true){
			return SUCCESS;
		}else{
			return "failure";
		}
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

}
