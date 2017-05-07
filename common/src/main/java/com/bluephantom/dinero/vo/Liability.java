package com.bluephantom.dinero.vo;

import java.util.ArrayList;

import com.bluephantom.dinero.model.FinancialObject;

public class Liability extends FinancialObject {

	public String getLiabilityLabel() {
		return liabilityLabel;
	}

	public void setLiabilityLabel(String liabilityLabel) {
		this.liabilityLabel = liabilityLabel;
	}

	public String getLiabilityId() {
		return liabilityId;
	}

	public void setLiabilityId(String liabilityId) {
		this.liabilityId = liabilityId;
	}

	public Double getLiabilityValue() {
		return liabilityValue;
	}

	public void setLiabilityValue(Double liabilityValue) {
		this.liabilityValue = liabilityValue;
	}

	public Liability() {
		this.liabilityId = "LiabilityId_01";
		this.liabilityLabel = "LiabilityLabel_01";
		super.setCashflows(new ArrayList<Cashflow>());
		super.setFinObjIdentifier("Liability");
	}

	public Liability(String liabilityId, String liabilityLabel) {
		this.liabilityId = liabilityId;
		this.liabilityLabel = liabilityLabel;
		super.setCashflows(new ArrayList<Cashflow>());
		super.setFinObjIdentifier("Liability");
	}

	public Liability(ArrayList<Cashflow> cashflows) {
		this.liabilityId = "LiabilityId_01";
		this.liabilityLabel = "LiabilityLabel_01";
		super.setCashflows(cashflows);
		super.setFinObjIdentifier("Liability");
	}

	public Liability(String liabilityId, String liabilityLabel, ArrayList<Cashflow> cashflows) {
		this.liabilityId = liabilityId;
		this.liabilityLabel = liabilityLabel;
		super.setCashflows(cashflows);
		super.setFinObjIdentifier("Liability");
	}

	public Liability(String liabilityId, String liabilityLabel, String finObjIdentifier, Double liabilityValue,
			ArrayList<Cashflow> cashflows) {
		this.liabilityId = liabilityId;
		this.liabilityLabel = liabilityLabel;
		super.setCashflows(cashflows);
		super.setFinObjIdentifier(finObjIdentifier);
	}

	private String liabilityLabel;
	private String liabilityId;
	private Double liabilityValue;

}
