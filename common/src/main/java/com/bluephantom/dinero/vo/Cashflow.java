package com.bluephantom.dinero.vo;

import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluephantom.dinero.model.CashflowType;
import com.bluephantom.dinero.model.FinancialValuation;

public class Cashflow implements FinancialValuation {

	private static final Logger logger = LogManager.getLogger(Cashflow.class);

	public String getCashflowLabel() {
		return cashflowLabel;
	}

	public void setCashflowLabel(String cashflowLabel) {
		this.cashflowLabel = cashflowLabel;
	}

	public String getCashflowId() {
		return cashflowId;
	}

	public void setCashflowId(String cashflowId) {
		this.cashflowId = cashflowId;
	}

	public String getCashflowOwner() {
		return cashflowOwner;
	}

	public void setCashflowOwner(String cashflowOwner) {
		this.cashflowOwner = cashflowOwner;
	}

	public CashflowType getCashflowType() {
		return cashflowType;
	}

	public void setCashflowType(CashflowType cashflowType) {
		this.cashflowType = cashflowType;
	}

	public Date getCashflowDate() {
		return cashflowDate;
	}

	public void setCashflowDate(Date cashflowDate) {
		this.cashflowDate = cashflowDate;
	}

	public Double getCashflowAmount() {
		return cashflowAmount;
	}

	public void setCashflowAmount(Double cashflowAmount) {
		// cashflowAmount should always be set as absolute value
		// we let the cashflowType determine the sign
		this.cashflowAmount = Math.abs(cashflowAmount);
	}

	public Double valuation() {
		Double localValue = 0.0;
		if (!this.cashflowAmount.equals(null)) {
			localValue = this.cashflowType.getSign() * this.cashflowAmount;
		}
		logger.debug("valuation >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	public Cashflow() {
		this.cashflowLabel = "Cashflow_01";
		this.cashflowId = new Long(Calendar.getInstance().getTimeInMillis()).toString();
		this.cashflowOwner = "CashflowOwner_01";
		this.cashflowType = CashflowType.IN;
		this.cashflowDate = Calendar.getInstance().getTime();
		this.cashflowAmount = 0.0;
	}

	@Override
	public String toString() {
		logger.debug(
				"toString >> cashflowLabel : {} cashflowId : {} cashflowOwner : {} cashflowType : {} cashflowDate : {} cashflowAmount : {}",
				cashflowLabel, cashflowId, cashflowOwner, cashflowType, cashflowDate, cashflowAmount);
		return "cashflowLabel : " + cashflowLabel + "cashflowId : " + cashflowId + "cashflowOwner : " + cashflowOwner
				+ "cashflowType : " + cashflowType + "cashflowDate : " + cashflowDate.toString() + "cashflowAmount : "
				+ cashflowAmount.toString();
	}

	private String cashflowLabel;
	private String cashflowId;
	private String cashflowOwner;
	private CashflowType cashflowType;
	private Date cashflowDate;
	private Double cashflowAmount;

}
