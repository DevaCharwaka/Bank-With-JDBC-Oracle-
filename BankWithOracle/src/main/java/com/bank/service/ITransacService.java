package com.bank.service;

import com.bank.beans.MoneyTransfer;

public interface ITransacService {
	
	public int withdraw (int amt, long acc) throws Exception;
	public int deposit (int amt, long acc) throws Exception;
	public int fundTransfer(long toAccNo, long fromAccNo, int amt) throws Exception;
	public int showBal(long accNo) throws Exception;
}
