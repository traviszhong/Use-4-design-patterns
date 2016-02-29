package com.bankin.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class CheckLogin {
	
	private String driver;
	private String dbURL;
	private String uname;
	private String pword;
	private boolean successflag;
	
	public CheckLogin(){
		
		this.driver = "com.mysql.jdbc.Driver";
		this.dbURL = "jdbc:mysql://localhost:3306/banksys";
		this.uname = "root";
		this.pword = "root";
		successflag = false;
	}
	public boolean checkLogin(String userName, String password){
		
		Connection dbConn;
		try {
			Class.forName(driver);
			dbConn = DriverManager.getConnection(dbURL, uname, pword);
			Statement st = dbConn.createStatement();
			ResultSet rs;
			rs=st.executeQuery("select * from t_user WHERE USERNAME='"+userName+"' and PASSWORD='"+password+"'");
			if(rs.next()){
				this.successflag = true;
			}
			dbConn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.successflag;
	}

}
