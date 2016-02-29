package com.bankin.utils;

public class PretransferChecker implements Service {
	
	private CheckBalance cb;
	public double commit(String userName) {
		// TODO Auto-generated method stub
		cb = new CheckBalance();
		return cb.commit(userName); //Adapter Here
	}

	public boolean commit(String userName, String accountNumber, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
