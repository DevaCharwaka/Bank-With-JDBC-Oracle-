package com.bank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.bank.beans.Signing;
import com.bank.utility.Database;
public class SignImplDAO implements ISigningDAO{
	
	
	public Signing registration(Signing reg) throws Exception {
		Database db =  new Database();
		 Connection con = db.getConnection();
		String  statement ="insert into customer_details values(cust_seq.nextval,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(statement);
	//	pst.setLong(0, );
		pst.setString(1, reg.getFirstName());
		
		pst.setString(2, reg.getLastName());
		
		pst.setString(3, reg.getEmailId());
		
		pst.setString(4, reg.getPassword());
		
		pst.setLong(5, reg.getAadharNo());
		
		pst.setLong(6, reg.getPanCard());
		
		pst.setString(7, reg.getAddress());
		
		pst.setLong(8, reg.getMobileNo());
		
		pst.setInt(9, reg.getBalance());
		pst.executeUpdate();
		long aadhar = reg.getAadharNo();
		
		PreparedStatement st = con.prepareStatement("select account_no from customer_details where aadhar_no=?");
		
		st.setLong(1, aadhar);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
		reg.setAccountNo(rs.getLong(1));
			}
		
		return reg;
		}

	public Signing login(long accNo, String pw) throws Exception {
		// checking the account number and password and doing Login operation 
		Database db1 =  new Database();
		 Connection con = db1.getConnection();
		int count =0;
		 Signing obj  = new Signing();
		 PreparedStatement st = con.prepareStatement("select * from customer_details where account_no=? and password = ?");
		 st.setLong(1, accNo);
		 st.setString(2, pw);
		 ResultSet rs = st.executeQuery();
		 while(rs.next()) {
			obj.setBalance(rs.getInt("balance"));
			obj.setAccountNo(rs.getLong(1));
		 count++;
		 }
		if(count==0)	
			return null;
		else return obj;

	}

}
