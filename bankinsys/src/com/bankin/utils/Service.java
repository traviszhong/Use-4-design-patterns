package com.bankin.utils;

import java.sql.SQLException;

public interface Service {

	public double commit(String userName);
	public boolean commit(String userName, String accountNumber, double amount);
}
