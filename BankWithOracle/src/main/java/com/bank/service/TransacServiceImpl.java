package com.bank.service;

import com.bank.beans.MoneyTransfer;
import com.bank.dao.ITransactionDAO;
import com.bank.dao.TransacImplDAO;

public class TransacServiceImpl implements ITransacService {

	ITransactionDAO obj = new TransacImplDAO();
	
	public int withdraw(int amt, long acc) throws Exception {
		
		return obj.withdraw(amt, acc);
	}

	public int deposit(int amt, long acc) throws Exception{
		// TODO Auto-generated method stub
		return obj.deposit(amt, acc);
	}

	public int fundTransfer(long toAccNo, long fromAccNo, int amt) throws Exception{
		// TODO Auto-generated method stub
		return obj.fundTransfer(toAccNo, fromAccNo, amt);
	}

	public boolean checkAadhar(long aadhar) {
		if(Long.toString(aadhar).length()==12)
			return true;
		else 
			return false;
		
	}

	public boolean checkMobile(long mob) {
		if(Long.toString(mob).length()==10)
			return true;
		else 
		return false;
	}

	public int showBal(long accNo) throws Exception {
		// TODO Auto-generated method stub
		return obj.showBal(accNo);
	}

}
