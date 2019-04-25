package com.bank.transactionService;

import com.bank.model.Account;
import com.bank.transactiondao.BankTransactionDaoImpl;

public class BankTransactionServiceImpl implements BankTransactionService{

	static BankTransactionDaoImpl transdao=new BankTransactionDaoImpl();
	
	
	public int withdraw(Account account,int amt) {
		int m=transdao.withdraw(account,amt);
		return m;
	}

	public int deposit(Account account,int amt) {
		int n=transdao.deposit(account,amt);
		return n;
	}


	public boolean validateAadhar(long aadharNo) {
		long n=aadharNo;
		
		if(Long.toString(n).length()==12)
			
			return true;	
		
		
	else
		return false;
	}

}
