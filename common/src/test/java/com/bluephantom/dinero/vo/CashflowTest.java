package com.bluephantom.dinero.vo;

import java.util.Calendar;

import com.bluephantom.dinero.model.CashflowType;
import com.google.gson.Gson;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CashflowTest extends TestCase {

	private Cashflow cashflow;

	public CashflowTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(CashflowTest.class);
	}

	public void setUp() throws Exception {
		super.setUp();
		String cfId = new Long(Calendar.getInstance().getTimeInMillis()).toString();
		System.out.println("CashflowTest::setUp >> The cashflow Id is : " + cfId);
		cashflow = new Cashflow();
		cashflow.setCashflowId(cfId);
		System.out.println("CashflowTest::setUp >> The cashflow Id is : " + cashflow.getCashflowId());
	}

	public void testPositiveInput() {
		System.out.println("CashflowTest::testPositiveInput >> The cashflow Id is : " + cashflow.getCashflowId());
		cashflow.setCashflowAmount(-15.0);
		assertEquals(this.cashflow.getCashflowAmount(), 15.0);
	}

	public void testValuation() {
		System.out.println("CashflowTest::testValuation >> The cashflow Id is : " + cashflow.getCashflowId());
		cashflow.setCashflowAmount(100.0);
		cashflow.setCashflowType(CashflowType.OUT);
		assertEquals(this.cashflow.valuation(), -100.0);
	}
	
	public void testGson(){
		String out = new Gson().toJson(cashflow);
		System.out.println(out);
	}
}
