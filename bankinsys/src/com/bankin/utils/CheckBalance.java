package com.bankin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckBalance implements Service {

	private String driver;
	private String dbURL;
	private String uname;
	private String pword;
	private double balance;
	
	public CheckBalance(){
		this.driver = "com.mysql.jdbc.Driver";
		this.dbURL = "jdbc:mysql://localhost:3306/banksys";
		this.uname = "root";
		this.pword = "root";
	}
	public double commit(String userName) {
		// TODO Auto-generated method stub
		
		Connection dbConn;
		try {
			Class.forName(driver);
			dbConn = DriverManager.getConnection(dbURL, uname, pword);
			Statement st = dbConn.createStatement();
			ResultSet rs;
			rs=st.executeQuery("select BALANCE from t_account WHERE USERNAME='"+userName+"'");
			if(rs.next()){
				this.balance = Double.valueOf(rs.getString(1)).doubleValue();
			}
			dbConn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.balance;
	}

	public boolean commit(String userName, String accountNumber, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
