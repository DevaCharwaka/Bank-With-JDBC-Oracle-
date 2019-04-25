package com.bank.beans;

public class Signing {

	private long accountNo;

	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String password;
	
	private long panCard;
	
	private String address;
	
	private long mobileNo;
	
	private int balance;

	private long aadharNo;
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPanCard() {
		return panCard;
	}
	public void setPanCard(long panCard) {
		this.panCard = panCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	public Signing(String firstName, String lastName, String emailId, String password, long panCard,
			 long aadharNo,	String address, long mobileNo, int balance) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.panCard = panCard;
		this.address = address;
		this.mobileNo = mobileNo;
		this.balance = balance;
		this.aadharNo = aadharNo;
	}
	public Signing() {
	
	}
	
}
