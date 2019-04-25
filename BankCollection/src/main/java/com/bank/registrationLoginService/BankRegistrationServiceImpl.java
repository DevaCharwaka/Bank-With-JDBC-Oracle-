package com.bank.registrationLoginService;

import java.util.Random;

import com.bank.model.Account;
import com.bank.registerationlogindao.BankRegistrationDaoImpl;

public class BankRegistrationServiceImpl implements BankRegistrationService {
	static BankRegistrationDaoImpl dao=new BankRegistrationDaoImpl(); 
	static Account account=new Account(); 
	
	public Account Login(long accountNo, String pwd) {
		account= dao.Login(accountNo,pwd);
		return account;
	}

	public long registration(Account account) {
		Random r=new Random();
		long accountNo= Math.abs(r.nextLong());
		account.setAccountNo(accountNo);
		long accNo=dao.registration(account);
		return accNo;
	}
	public boolean validate(long aadharNo) {
		boolean bl=dao.validate(aadharNo);
		return bl;
	}
	public int fundTransfer(Account account,int amount,long toAccountNo,int amt) {
		int k=dao.fundTransfer(account,amount,toAccountNo,amt);
		return k;
	}
}
