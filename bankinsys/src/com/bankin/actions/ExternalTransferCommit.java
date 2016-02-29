package com.bankin.actions;

import com.bankin.service.ExternalTransferor;
import com.bankin.service.ImplExternalTransferor;
import com.opensymphony.xwork2.ActionSupport;

public class ExternalTransferCommit extends ActionSupport {

	private double amount;
	private String account_number;
	private String username;
	private ExternalTransferor et;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean res;
		et = new ImplExternalTransferor();
		res = et.makeExternalTransfer(username, account_number, amount);
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
