package com.bank.transactiondao;

import com.bank.model.Account;

public interface BankTransactionDao {
	public int withdraw(Account account,int amt);
	public int deposit(Account account,int amt);
//	public int fundTransfer(Account account,int amount,long toAccountNo,int amt);
}
