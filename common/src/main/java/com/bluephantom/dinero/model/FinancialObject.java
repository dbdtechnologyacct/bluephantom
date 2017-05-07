package com.bluephantom.dinero.model;

import java.util.ArrayList;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluephantom.dinero.vo.Cashflow;

public abstract class FinancialObject implements FinancialValuation {

	private static final Logger logger = LogManager.getLogger(FinancialObject.class);

	public ArrayList<Cashflow> getCashflows() {
		return cashflows;
	}

	public void setCashflows(ArrayList<Cashflow> cashflows) {
		this.cashflows = cashflows;
	}

	public String getFinObjIdentifier() {
		return finObjIdentifier;
	}

	public void setFinObjIdentifier(String finObjIdentifier) {
		this.finObjIdentifier = finObjIdentifier;
	}

	public void addCashflow(Cashflow cashflow) {
		if (CollectionUtils.isEmpty(cashflows)) {
			this.cashflows = new ArrayList<Cashflow>();
		}
		this.cashflows.add(cashflow);
	}

	public void removeCashflow(Cashflow cashflow) {
		if (CollectionUtils.isNotEmpty(cashflows)) {
			this.cashflows.remove(cashflow);
		}
	}

	public void addCashflows(ArrayList<Cashflow> cashflows) {
		if (CollectionUtils.isEmpty(cashflows)) {
			this.cashflows = new ArrayList<Cashflow>();
		}
		this.cashflows.addAll(cashflows);
	}

	public void removeCashflows(ArrayList<Cashflow> cashflows) {
		if (CollectionUtils.isNotEmpty(cashflows)) {
			this.cashflows.removeAll(cashflows);
		}
	}

	public Double valuation() {
		Double localValue = 0.0;
		if (!this.cashflows.equals(null)) {
			localValue = cashflows.stream().mapToDouble(cashflow -> cashflow.valuation()).sum();
		}
		logger.debug("valuation >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	private ArrayList<Cashflow> cashflows;
	private String finObjIdentifier;

}
