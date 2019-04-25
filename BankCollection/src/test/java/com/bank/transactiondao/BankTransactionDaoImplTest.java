package com.bank.transactiondao;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import com.bank.model.Account;
import com.bank.registerationlogindao.BankRegistrationDaoImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;


class BankTransactionDaoImplTest {
	
static BankTransactionDaoImpl test=new BankTransactionDaoImpl();
static Account account = new Account();	
//@BeforeAll

@Test
 void testDeposit() {
	account.setAadharNo(987745);
	account.setFirstName("vijay");
	account.setLastName("reddy");
	account.setEmailId("vijay@gmail.com");
	account.setPancardNo("44565");
	account.setMobileNo(845513);
	account.setPassword("12345");
	account.setAddress("hyd");
	account.setAccountNo(123456789);

	assertEquals(1, test.deposit(account, 100));
	 }

	 @Test
	 void testWithdraw() {
		 account.setBalance(500);
	 assertEquals(1, test.withdraw(account, 50));
	 }

}
