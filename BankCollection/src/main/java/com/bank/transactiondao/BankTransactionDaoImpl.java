package com.bank.transactiondao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import com.bank.model.Account;

public class BankTransactionDaoImpl implements BankTransactionDao{
	Scanner sc = new Scanner(System.in);

//withdraw
	public int withdraw(Account account,int amt) {
		int i = 0;
		
			if (amt > account.getBalance()) {
				System.out.println("insufficient balance plz deposit");
			} 
			else {
				
				account.setBalance(account.getBalance()-amt);
				i=1;
			}

		
		if (i == 1)
			return i;
		else
			return 0;

	}

//deposit
	public int deposit(Account account,int amt) {
		int i=0;
		if(amt>0) {
			i=1;
		 account.setBalance(account.getBalance()+amt);
		}
		if (i == 1)
			return i;
		else
			return 0;

	}


	
}
