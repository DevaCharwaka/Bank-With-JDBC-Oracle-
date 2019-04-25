package com.bank.exceptions;

public class MobileCheck extends Exception {

	public MobileCheck() {
		System.err.println("mobile  number should be 10 digits");
	}
}
