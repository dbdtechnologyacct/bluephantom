package com.bluephantom.dinero.app;

import java.util.Calendar;

import com.bluephantom.dinero.model.CashflowType;
import com.bluephantom.dinero.vo.Asset;
import com.bluephantom.dinero.vo.Cashflow;
import com.bluephantom.dinero.vo.Income;

import junit.framework.TestCase;

public class DineroAppTest extends TestCase {

	private DineroApp app;
	
	public DineroAppTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		app = DineroApp.getInstance();
	}

	public void testApp() {
		Calendar c = Calendar.getInstance();
		c.set(2017, 5, 24);
		Income income1 = new Income("CF Owner1", "CF 1", 10.0, c.getTime());
		c.set(2017, 5, 23);
		Income income2 = new Income("CF Owner2", "CF 1", 15.0, c.getTime());
		app.getIncomeManager().addIncome(income1);
		app.getIncomeManager().addIncome(income2);

		Asset asset1 = new Asset("Asset 1", "Asset 1", "Asset 1", 50.0);
		Cashflow cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(1.0);
		Cashflow cf2 = new Cashflow();
		cf2.setCashflowAmount(2.0);
		cf2.setCashflowType(CashflowType.IN);
		Cashflow cf3 = new Cashflow();
		cf3.setCashflowAmount(3.0);
		cf3.setCashflowType(CashflowType.OUT);
		asset1.addCashflow(cf1);
		asset1.addCashflow(cf2);
		asset1.addCashflow(cf3);
		app.getIncomeManager().addAsset(asset1);
		Asset asset2 = new Asset("Asset 2", "Asset 2", "Asset 2", 100.0);
		cf1 = new Cashflow();
		cf1.setCashflowType(CashflowType.OUT);
		cf1.setCashflowAmount(4.0);
		cf2 = new Cashflow();
		cf2.setCashflowAmount(5.0);
		cf2.setCashflowType(CashflowType.IN);
		cf3 = new Cashflow();
		cf3.setCashflowAmount(6.0);
		cf3.setCashflowType(CashflowType.OUT);
		asset2.addCashflow(cf1);
		asset2.addCashflow(cf2);
		asset2.addCashflow(cf3);
		app.getIncomeManager().addAsset(asset2);
		assertEquals(app.getIncomeManager().valuation(), 18.0);
		
	}
	
}
