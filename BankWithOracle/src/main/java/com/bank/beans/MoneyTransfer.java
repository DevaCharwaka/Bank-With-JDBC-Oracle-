package com.bank.beans;

public class MoneyTransfer {
	private int transactionId;
	private long fromAccNo;
	private long toAccNo;
	private int amtTransfered;
public MoneyTransfer(int transactionId, long fromAccNo, long toAccNo, int amtTransfered) {
		
		this.transactionId = transactionId;
		this.fromAccNo = fromAccNo;
		this.toAccNo = toAccNo;
		this.amtTransfered = amtTransfered;
	}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public long getFromAccNo() {
	return fromAccNo;
}
public void setFromAccNo(long fromAccNo) {
	this.fromAccNo = fromAccNo;
}
public long getToAccNo() {
	return toAccNo;
}
public void setToAccNo(long toAccNo) {
	this.toAccNo = toAccNo;
}
public int getAmtTransfered() {
	return amtTransfered;
}
public void setAmtTransfered(int amtTransfered) {
	this.amtTransfered = amtTransfered;
}
	public MoneyTransfer() {
		
	}
}
