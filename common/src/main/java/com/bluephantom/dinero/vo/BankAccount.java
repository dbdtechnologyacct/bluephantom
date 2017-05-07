package com.bluephantom.dinero.vo;

import java.util.ArrayList;

import com.bluephantom.dinero.model.FinancialObject;

public class BankAccount extends FinancialObject {

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BankAccount() {
		this.accountNumber = "Account Number";
		this.bankName = "Bank Name";
		super.setCashflows(new ArrayList<Cashflow>());
		super.setFinObjIdentifier("BankAccount");
	}

	public BankAccount(String bankName, String accountNumber) {
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		super.setCashflows(new ArrayList<Cashflow>());
		super.setFinObjIdentifier("BankAccount");
	}

	public BankAccount(ArrayList<Cashflow> cashflows) {
		this.accountNumber = "Account Number";
		this.bankName = "Bank Name";
		super.setCashflows(cashflows);
		super.setFinObjIdentifier("BankAccount");
	}

	public BankAccount(String bankName, String accountNumber, ArrayList<Cashflow> cashflows) {
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		super.setCashflows(cashflows);
		super.setFinObjIdentifier("BankAccount");
	}

	public BankAccount(String bankName, String accountNumber, String finObjIdentifier, ArrayList<Cashflow> cashflows) {
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		super.setCashflows(cashflows);
		super.setFinObjIdentifier(finObjIdentifier);
	}

	private String bankName;
	private String accountNumber;

}
