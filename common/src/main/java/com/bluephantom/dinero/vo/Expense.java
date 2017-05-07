package com.bluephantom.dinero.vo;

import java.util.Date;

import com.bluephantom.dinero.model.CashflowType;

public class Expense extends Cashflow {

	public Expense(String cashflowOwner, String cashflowLabel, Double cashflowAmount, Date cashflowDate) {
		super.setCashflowOwner(cashflowOwner);
		super.setCashflowLabel(cashflowLabel);
		super.setCashflowAmount(cashflowAmount);
		super.setCashflowDate(cashflowDate);
		super.setCashflowType(CashflowType.OUT);
	}

}
