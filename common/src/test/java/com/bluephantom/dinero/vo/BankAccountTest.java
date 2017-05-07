package com.bluephantom.dinero.vo;

import java.util.ArrayList;

import com.bluephantom.dinero.model.CashflowType;
import com.google.gson.Gson;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BankAccountTest extends TestCase {

	private BankAccount bankAccount;

	public BankAccountTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(BankAccountTest.class);
	}

	public void setUp() throws Exception {
		bankAccount = new BankAccount();
	}

	public void testConstructorWithArrayListArg() {
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(1000.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(1500.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(3.0);
		cf3.setCashflowType(CashflowType.OUT);
		ArrayList<Cashflow> cashflows = new ArrayList<Cashflow>();
		cashflows.add(cf1);
		cashflows.add(cf2);
		cashflows.add(cf3);
		bankAccount = new BankAccount(cashflows);
		assertEquals(bankAccount.getCashflows().size(), 3);
	}

	public void testAddingCashflowWithNullList() {
		// we are deliberately setting the cashflow list to null
		bankAccount.setCashflows(null);
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowAmount(100.0);
		bankAccount.addCashflow(cf1);
		assertEquals(bankAccount.getCashflows().size(), 1);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(150.0);
		bankAccount.addCashflow(cf2);
		assertEquals(bankAccount.getCashflows().size(), 2);
	}

	public void testRemovingCashflow() {
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(1000.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(1500.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(3.0);
		cf3.setCashflowType(CashflowType.OUT);
		ArrayList<Cashflow> cashflows = new ArrayList<Cashflow>();
		cashflows.add(cf1);
		cashflows.add(cf2);
		cashflows.add(cf3);
		bankAccount.addCashflows(cashflows);
		bankAccount.removeCashflow(cf1);
		assertEquals(bankAccount.getCashflows().size(), 2);
	}

	public void testRemovingMultipleCashflows() {
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(1.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(2.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(3.0);
		cf3.setCashflowType(CashflowType.OUT);
		ArrayList<Cashflow> cashflows = new ArrayList<Cashflow>();
		cashflows.add(cf1);
		cashflows.add(cf3);
		bankAccount.addCashflows(cashflows);
		bankAccount.addCashflow(cf2);
		assertEquals(bankAccount.getCashflows().size(), 3);
		ArrayList<Cashflow> toRemove = new ArrayList<Cashflow>();
		toRemove.add(cf1);
		toRemove.add(cf2);
		bankAccount.removeCashflows(toRemove);
		assertEquals(bankAccount.getCashflows().get(0), cf3);
	}

	public void testAddCashflows() {
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(1.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(2.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(3.0);
		cf3.setCashflowType(CashflowType.OUT);
		ArrayList<Cashflow> cashflows = new ArrayList<Cashflow>();
		cashflows.add(cf1);
		cashflows.add(cf2);
		cashflows.add(cf3);
		bankAccount.addCashflows(cashflows);
		assertEquals(bankAccount.getCashflows().size(), 3);
	}

	public void testValuation() {
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(1000.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(1500.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(3.0);
		cf3.setCashflowType(CashflowType.OUT);
		ArrayList<Cashflow> cashflows = new ArrayList<Cashflow>();
		cashflows.add(cf1);
		cashflows.add(cf2);
		cashflows.add(cf3);
		bankAccount = new BankAccount(cashflows);
		assertEquals(bankAccount.valuation(), 497.0);
	}

	public void testGson() {
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(123.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(456.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(789.0);
		cf3.setCashflowType(CashflowType.OUT);
		bankAccount.addCashflow(cf1);
		bankAccount.addCashflow(cf2);
		bankAccount.addCashflow(cf3);
		String out = new Gson().toJson(bankAccount);
		System.out.println(out);
	}
}
