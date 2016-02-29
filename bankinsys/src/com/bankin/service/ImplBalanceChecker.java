package com.bankin.service;

import com.bankin.utils.Service;
import com.bankin.utils.ServiceFactory;;

public class ImplBalanceChecker implements BalanceChecker{

	private Service sv;
	public double checkBalance(String userName) {
		// TODO Auto-generated method stub
		sv = ServiceFactory.buildService(1); //Factory Method Here
		return sv.commit(userName);
	}

}
