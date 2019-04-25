package com.bank.registerationlogindao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bank.model.Account;

public class BankRegistrationDaoImpl implements BankRegistrationDao {
	Map<Long, Account> accountEntry = new HashMap<Long, Account>();
	 Account account = new Account();
	Scanner sc = new Scanner(System.in);

//registration
	public long registration(Account account) {


		accountEntry.put(account.getAccountNo(),
				new Account(account.getFirstName(), account.getLastName(), account.getEmailId(), account.getPassword(),
						account.getPancardNo(), account.getAadharNo(), account.getAddress(), account.getMobileNo(),
						account.getBalance()));

		return account.getAccountNo();
	}

//Login	
	public Account Login(long accountNo, String pwd) {
		int count = 0;
		for (Map.Entry<Long, Account> me : accountEntry.entrySet()) {

			if (accountNo == me.getKey()) {
				account = me.getValue();
				if (pwd.equals(account.getPassword())) {
					count++;
				}
			}

		}

		if (count == 0)
			return null;
		else
			return account;
	}

//validate method	
	public boolean validate(long aadharNo) {

		int count = 0;
		for (Map.Entry<Long, Account> me : accountEntry.entrySet()) {
			if (aadharNo == me.getValue().getAadharNo()) {
				System.out.println("getVlaue");
				count++;
			}

		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}

	}

	// fund transfer
	public int fundTransfer(Account account, int amount, long toAccountNo, int amt) {
		int i = 0;

		if (amt > amount) {
			System.out.println("insufficient balance plz deposit");
		} else {

			account.setBalance(amount - amt);
			for (Map.Entry<Long, Account> me : accountEntry.entrySet()) {

				if (toAccountNo == me.getKey()) {
				//	System.out.println("toAccount no. found");
				//	System.out.println(me.getKey());
					Account account2 = me.getValue();
					account2.setBalance(account2.getBalance() + amt);
					i++;
				}
			}

		}

		if (i == 1)
			return i;
		else
			return 0;
	}

}
