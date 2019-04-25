package com.bank.ui;
import com.bank.beans.Signing;
import com.bank.exceptions.AadharCheck;
import com.bank.exceptions.MobileCheck;
import com.bank.service.*;
import java.util.Scanner;

public class MainClass {
	static Scanner sc =  new Scanner(System.in);
	static ISignService service = new SignServiceImpl();
	static TransacServiceImpl ser = new TransacServiceImpl();

	public static Signing setInfo() throws Exception{
		Signing entry  = new Signing();
		System.out.println("Enter First Name");
		entry.setFirstName(sc.next());
		System.out.println("Enter the last Name");
		entry.setLastName(sc.next());
		System.out.println("Enter the email id");
		entry.setEmailId(sc.next());
		System.out.println("Enter the password for account");
		entry.setPassword(sc.next());
		System.out.println("Enter the pan card number");
		entry.setPanCard(sc.nextLong());
		System.out.println("Enter the aadhar card number");
		long aadhar = sc.nextLong();
		boolean aadharCheck =ser.checkAadhar(aadhar);
		if(aadharCheck)
		entry.setAadharNo(aadhar);
		else {
			throw new AadharCheck();
			
		}
		System.out.println("Enter the address");
		entry.setAddress(sc.next());
		System.out.println("Enter the mobile number");
		long mob = sc.nextLong();
		boolean mobCheck = ser.checkMobile(mob);
		if(mobCheck)
		entry.setMobileNo(mob);
		else {
			throw new MobileCheck();
		}
		entry.setBalance(0);

		Signing reg = service.registration(entry);
		return reg;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		int choose;
		ITransacService serv = new TransacServiceImpl();
		Signing obj1 =  null;
		while(true) {
		System.out.println("Enter \n1.Registration \n2.Login \n3.Exit");	
		choose = sc.nextInt();
		switch(choose) {
		
		case 1:	//Registration 
						obj1  = setInfo();
						System.out.println("Your account number is "+obj1.getAccountNo());
						break;
		
		case 2:	//Login	
					int ch;
					System.out.println("Enter the acc no");
						long accNo = sc.nextLong();
						System.out.println("enter the password");
						String pw = sc.next();
						Signing obj2 = service.login(accNo,pw);	
						if(obj2!=null) {
						while(true) {
							System.out.println("1.Withdraw \n2.Deposit \n3.Fund Transfer \n4.View balance \n5.Exit");
							ch  = sc.nextInt();
							
								switch(ch) {
							
							case 1:		System.out.println("enter the account number ");
										long acc = sc.nextLong();
											System.out.println("Enter the amount to withdraw");
											if(accNo!=acc) {
												System.err.println("account number mismatch");
												System.exit(0);
											}
											int withdrawAmt = sc.nextInt();
											int withdraw = serv.withdraw(withdrawAmt,acc);
											if(withdraw==0)
												System.out.println("wrong account number");
											else if(withdraw==2){
											System.out.println("Low balance in your account");
											}
											else {
							System.out.println(" after withdraw your account balance is "+withdraw);	
											}	break;
							case 2:	System.out.println("enter the account number ");
									long acc1 = sc.nextLong();
									if(accNo!=acc1) {
										System.err.println("account number mismatch");
										System.exit(0);
									}

									
									System.out.println("Enter the amount to deposit");
									int depositAmt = sc.nextInt();
									int deposit = serv.deposit(depositAmt, acc1);
									if(deposit==0)
										System.out.println("wrong account number");
									else
										System.out.println(" after deposit your account balance is "+deposit);	
									break;
							
							case 3: System.out.println("Enter account number of receiver");
									long to = sc.nextLong();
							//	System.out.println("enter account number of sender");
							long from = obj2.getAccountNo();
									System.out.println("enter thhe amount to send");
							int amt =  sc.nextInt();
									int fundTransfers = serv.fundTransfer(to,from,amt);
									if(fundTransfers==0)
										System.out.println("low balance ");
									else
										System.out.println("amount transfered is "+amt+" after transfering your balance is "+serv.showBal(accNo));
										break;
							case 4: System.out.println(" your balance is "+serv.showBal(accNo));			
									break;
							case 5: //Exit
								System.exit(0);				
								}
							}
						}
						
						else
							System.out.println("wrong user name and password");
						
						
						break;
		
						case 3: //Exit
									System.exit(0);				
			
		}
		}
	}

}
