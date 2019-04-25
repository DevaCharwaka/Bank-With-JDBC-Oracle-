package com.bank.registrationLoginService;

import com.bank.model.Account;

public interface BankRegistrationService {
	public Account Login(long accountNo,String password);
	public long registration(Account account);
	public boolean validate(long aadharNo);
	public int fundTransfer(Account account,int amount,long toAccountNo,int amt);
}
