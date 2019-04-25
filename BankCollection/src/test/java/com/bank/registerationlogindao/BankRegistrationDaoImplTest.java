package com.bank.registerationlogindao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import com.bank.model.Account;
import org.junit.jupiter.api.Test;

 public class BankRegistrationDaoImplTest {

	 
/*
	 
 */
//	 @BeforeAll
	 
static  BankRegistrationDaoImpl test = new BankRegistrationDaoImpl();	
static Account acc = new Account();

	 @Test
	 public  void testRegistration() {
	
		 Account account = new Account();		
		 account.setAadharNo(123654789654L);
		account.setFirstName("deva");
		account.setLastName("reddy");
		account.setEmailId("deva@gmail.com");
		account.setPancardNo("44567");
		account.setMobileNo(954829731);
		account.setPassword("12345");
		account.setAddress("hyd");
		account.setAccountNo(123456789);
		//	account.
		
		long accNo= test.registration(account);
		
		assertEquals(123456789,accNo);
//		dao.registration(account)
	}


@Test
void testvalidate()
{
assertEquals(false, test.validate(987745));
}


	 
	 @Test
	 void testLogin() {

		 Account account = new Account();		
		 account.setAadharNo(123654789654L);
		account.setFirstName("deva");
		account.setLastName("reddy");
		account.setEmailId("deva@gmail.com");
		account.setPancardNo("44567");
		account.setMobileNo(954829731);
		account.setPassword("12345");
		account.setAddress("hyd");
		account.setAccountNo(123456789);
		test.registration(account);
		 Account acc = test.Login(123456789L,"12345");
		 String place = acc.getAddress();
	 assertEquals("hyd", place);
	 }
	 
		@Test
		void testFundTransfer() {
			
///			 BankRegistrationDaoImpl test = new BankRegistrationDaoImpl();

			assertEquals(0,test.fundTransfer(acc,300,1000000, 100));
		}




}
