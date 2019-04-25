package com.bank.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bank.beans.MoneyTransfer;
import com.bank.beans.Signing;

class TransacImplDAOTest {

@Test
void testWithdraw() throws Exception {
TransacImplDAO trans=new TransacImplDAO();
MoneyTransfer transfer=new MoneyTransfer();
//Signing cust=new Signing();
//cust.setBalance(100);
//cust.setAccountNo(1111100001);
int ret =trans.withdraw(38000,1111100060);

assertEquals(2,ret);
//assertEquals(100,1111100001,trans.withdraw(100, 1111100001));
//assertEquals();
}

//private void AssertEquals(int i, int withdraw) {
//// TODO Auto-generated method stub
//
//}



@Test
void testDeposit() throws Exception {
TransacImplDAO trans=new TransacImplDAO();
//MoneyTransfer transfer=new MoneyTransfer();
//Signing cust=new Signing();
//cust.setBalance(100);
//cust.setAccountNo(1111100001);
int ret1=trans.deposit(5000,1111100085);

assertEquals(11000,ret1);

}

@Test
void testFundTransfer() throws Exception {
TransacImplDAO trans=new TransacImplDAO();
//MoneyTransfer transfer=new MoneyTransfer();
//Signing cust=new Signing();
//transfer.setToAccNo(100);
//transfer.setFromAccNo(200);
int cust2=trans.fundTransfer( 1111100001, 1111100020, 300);

assertEquals(1,cust2);

}

@Test
void testShowBalance() throws Exception{
	TransacImplDAO trans=new TransacImplDAO();
int bal = trans.showBal(1111100061);
assertEquals(18000,bal);

}
}