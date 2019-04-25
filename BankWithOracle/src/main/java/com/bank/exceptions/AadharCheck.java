package com.bank.exceptions;

public class AadharCheck extends Exception {

	public AadharCheck() {
		System.err.println("aadhar number should be 12 digits");
	}
}
