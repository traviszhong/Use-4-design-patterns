package com.bankin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExternalTransfer implements Service {

	private String driver;
	private String dbURL;
	private String uname;
	private String pword;
	private boolean successflag;
	private String sql_getbalance_orig;
	private String sql_getacnumber;
	private String sql_update_orig;
	private String sql_insert_transaction;
	private String sql_insert_external_transaction;
	public ExternalTransfer(){
		this.driver = "com.mysql.jdbc.Driver";
		this.dbURL = "jdbc:mysql://localhost:3306/banksys";
		this.uname = "root";
		this.pword = "root";
		this.sql_getbalance_orig = "select BALANCE from t_account where USERNAME = ?";
		this.sql_getacnumber = "select ACNUMBER from t_account where USERNAME = ?";
		this.sql_update_orig = "update t_account set BALANCE = ? where USERNAME =?";
		this.sql_insert_transaction = "insert into t_transaction(ORIGACC,DESTACC,AMOUNT) values(?,?,?)";
		this.sql_insert_external_transaction = "insert into t_external_transaction(ORIGACC,DESTACC,AMOUNT) values(?,?,?)";
	}
	public double commit(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean commit(String userName, String accountNumber, double amount){
		// TODO Auto-generated method stub
		Connection dbConn = null;
		PreparedStatement pst;
		ResultSet rs;
		double orig_balance = 0;
		String orig_acnumber = "";
		try {
			Class.forName(driver);
			dbConn = DriverManager.getConnection(dbURL, uname, pword);
			
			//get the balance of the origin
			pst = dbConn.prepareStatement(sql_getbalance_orig);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()){
				orig_balance = Double.valueOf(rs.getString(1)).doubleValue();
			}
			
			//get the account number of origin
			pst = dbConn.prepareStatement(sql_getacnumber);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()){
				orig_acnumber = rs.getString(1);
			}
			
			orig_balance = orig_balance - amount;
			
			//Update accounts information
			pst = dbConn.prepareStatement(sql_update_orig);
			pst.setString(1, Double.toString(orig_balance));
			pst.setString(2, userName);
			pst.executeUpdate();
			
			
			//Insert into external transaction DB
			pst = dbConn.prepareStatement(sql_insert_external_transaction);
			pst.setString(1, orig_acnumber);
			pst.setString(2, accountNumber);
			pst.setString(3, Double.toString(amount));
			pst.executeUpdate();
			
			dbConn.close();
			this.successflag = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			this.successflag = false;
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			this.successflag = false;
			e.printStackTrace();
		}
		return this.successflag;
	}

}
