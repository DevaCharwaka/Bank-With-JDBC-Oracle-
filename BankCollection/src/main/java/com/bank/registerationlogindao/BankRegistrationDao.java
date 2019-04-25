package com.bank.registerationlogindao;

import com.bank.model.Account;

public interface BankRegistrationDao {
	public Account Login(long accountNo,String password);
	public long registration(Account account);
	public int fundTransfer(Account account,int amount,long toAccountNo,int amt);
}
