package com.bankin.service;

import com.bankin.utils.Service;
import com.bankin.utils.ServiceFactory;;

public class ImplInternalTransferor implements InternalTransferor {

	private Service sv;
	public boolean makeInternalTransfer(String userName, String accountNumber,
			double amount) {
		// TODO Auto-generated method stub
		sv = ServiceFactory.buildService(2);
		return sv.commit(userName, accountNumber, amount);// Proxy
	}

}
