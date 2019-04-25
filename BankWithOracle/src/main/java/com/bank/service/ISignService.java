package com.bank.service;

import com.bank.beans.Signing;

public interface ISignService {
	
	public Signing registration(Signing reg) throws Exception;
	
	public Signing login (long accNo,String pw) throws Exception;
	
}
