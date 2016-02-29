package com.bankin.service;

public interface ExternalTransferor {

	public boolean makeExternalTransfer(String userName, String accountNumber, double amount);
}
