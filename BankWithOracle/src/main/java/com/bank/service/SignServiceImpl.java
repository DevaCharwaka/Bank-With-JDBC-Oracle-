package com.bank.service;
import com.bank.beans.*;
import com.bank.dao.*;


public class SignServiceImpl implements ISignService {

	ISigningDAO obj = new SignImplDAO();
	
	public Signing registration(Signing reg) throws Exception {
		
		return obj.registration(reg);
	}

	public Signing login(long accNo,String pw) throws Exception {

		Signing obj1 = obj.login(accNo, pw);
		
		return obj1;
	}

	
}
