package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.beans.MoneyTransfer;
import com.bank.utility.Database;

public class TransacImplDAO implements ITransactionDAO {

	public int withdraw(int amt, long account_no) throws Exception {
		int bal=0;
		long acc1=0;
		Database db = new Database();
			Connection con = db.getConnection();
			PreparedStatement st = con.prepareStatement("select * from customer_details where account_no =?");	
			st.setLong(1, account_no);
			ResultSet rs = st.executeQuery();
		while(rs.next()) {	
			bal = rs.getInt("balance");
		if(amt>bal) {
			return 2; // return 2 if withdraw amt is more than balance
		}
		acc1 = rs.getLong(1);
		
		}
			if(acc1==account_no)
			{
			PreparedStatement pst = con.prepareStatement("update customer_details set balance=? where account_No=?");
			pst.setInt(1,bal-amt);
			pst.setLong(2, account_no);
			pst.executeUpdate();
			return (bal-amt);
			}
			return 0;
	}
public int deposit(int amt,long account_no) throws Exception {
int bal1=0;
long acc=0;
		Database db = new Database();
		Connection con = db.getConnection();
		PreparedStatement st = con.prepareStatement("select * from customer_details where account_no =?");	
		st.setLong(1, account_no);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
		 bal1 = rs.getInt("balance");
			 acc =  rs.getLong(1);
	}

		if(acc==account_no)
		{
		PreparedStatement pst = con.prepareStatement("update customer_details set balance=? where account_No=?");
		pst.setInt(1,bal1+amt);
		pst.setLong(2, account_no);
		pst.executeUpdate();
		return bal1+amt;
		}

		return 0;
	}
public int showBal(long accNo) throws Exception {
int bal=0;
	Database db = new Database();
	Connection con = db.getConnection();
	PreparedStatement st = con.prepareStatement("select * from customer_details where account_no =?");	
	st.setLong(1, accNo);
	ResultSet rs = st.executeQuery();
while(rs.next()) {	
	bal = rs.getInt("balance");
}
return bal;
}

	public int fundTransfer(long toAccNo, long fromAccNo, int amt) throws Exception {

		int tranid=0;
	int checkbal=0;
		Database db = new Database();
		Connection con = db.getConnection();
		MoneyTransfer mt = new MoneyTransfer();

		PreparedStatement ps9=con.prepareStatement("select * from customer_details where account_no=? ");
		ps9.setLong(1,fromAccNo);
		ResultSet rs8 = ps9.executeQuery();	
		while(rs8.next()) {
			checkbal = rs8.getInt("balance");
		}
		if(amt>checkbal)
			return 0;
		
		else {
			PreparedStatement pst = con.prepareStatement("update customer_details set balance=? where account_No=?");
			pst.setInt(1,checkbal-amt);
			pst.setLong(2, fromAccNo);
			pst.executeUpdate();

			PreparedStatement ps2=con.prepareStatement("select * from customer_details where account_no=? ");
			ps2.setLong(1,toAccNo);
			ResultSet rs2 = ps2.executeQuery();	
			while(rs2.next())
			{
		int toAmount=rs2.getInt(10);
		PreparedStatement ps3 = con.prepareStatement("update customer_details set balance=? where account_No=?");
		ps3.setInt(1,(checkbal+amt) );
		ps3.setLong(2,toAccNo);
		ps3.executeUpdate();
			}
			PreparedStatement pst2 = con.prepareStatement("insert into transaction_details values(tran_seq.nextval,?,?,?)");
			pst2.setLong(1,fromAccNo);
			pst2.setLong(2, toAccNo);
			pst2.setInt(3,amt);
			int i=	pst2.executeUpdate();
		
//		PreparedStatement ps0 = con.prepareStatement("select * ")

		return i;
	
		}
		
	}
}

