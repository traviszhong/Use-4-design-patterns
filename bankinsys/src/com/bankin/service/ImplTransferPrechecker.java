package com.bankin.service;

import com.bankin.utils.Service;
import com.bankin.utils.ServiceFactory;

public class ImplTransferPrechecker implements TransferPrechecker {

	private Service sv;
	public double checkBalance(String userName) {
		// TODO Auto-generated method stub
		sv = ServiceFactory.buildService(4);
		return sv.commit(userName);
	}

}
