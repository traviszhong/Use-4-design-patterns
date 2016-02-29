package com.bankin.service;

import com.bankin.utils.CheckLogin;

public class ImplLoginChecker implements LoginChecker {

	private CheckLogin cl;
	public boolean checkLogin(String userName, String password) {
		// TODO Auto-generated method stub
		cl = new CheckLogin();
		return cl.checkLogin(userName, password);
	}

}
