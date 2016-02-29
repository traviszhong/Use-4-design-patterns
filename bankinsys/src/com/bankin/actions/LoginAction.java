package com.bankin.actions;

import com.bankin.service.ImplLoginChecker;
import com.bankin.service.LoginChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String j_username;
	private String j_password;
	private LoginChecker lc;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lc = new ImplLoginChecker();
		if(lc.checkLogin(j_username, j_password)){
			return SUCCESS; //MVC Here
		}else{
			return "failure";
		}
		
	}
	public String getJ_username() {
		return j_username;
	}
	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}
	public String getJ_password() {
		return j_password;
	}
	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

}
