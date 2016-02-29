package com.bankin.service;

public interface InternalTransferor {

	public boolean makeInternalTransfer(String userName, String accountNumber, double amount);
}
