package com.bank.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bank.beans.Signing;

class SignImplDAOTest {

@Test
void testRegistration() throws Exception {
SignImplDAO dao = new SignImplDAO();
Signing cust = new Signing();
cust.setFirstName("riya123");
cust.setLastName("reddy4");
cust.setEmailId("riya5@gmail.com");
cust.setPassword("riya");
cust.setAadharNo(721515131);
cust.setPanCard(987623654);
cust.setMobileNo(957345241);
cust.setBalance(1000);

Signing cust1=dao.registration(cust);

long i=cust1.getAadharNo();
assertEquals(i,721515131);

}

@Test

 void testLogin() throws Exception {
	SignImplDAO dao = new SignImplDAO(); 
	Signing cust = dao.login(1111100021,"kavi123"); 
	int bal= cust.getBalance();
	assertEquals(bal,50000);
	
 }


}