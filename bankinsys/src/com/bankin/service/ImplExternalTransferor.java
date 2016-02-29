package com.bankin.service;

import com.bankin.utils.Service;
import com.bankin.utils.ServiceFactory;

public class ImplExternalTransferor implements ExternalTransferor {

	private Service sv;
	public boolean makeExternalTransfer(String userName, String accountNumber,
			double amount) {
		// TODO Auto-generated method stub
		sv = ServiceFactory.buildService(3);
		return sv.commit(userName, accountNumber, amount);

	}

}
