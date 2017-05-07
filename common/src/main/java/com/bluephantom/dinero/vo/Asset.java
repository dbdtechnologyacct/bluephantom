package com.bluephantom.dinero.vo;

import java.util.ArrayList;

import com.bluephantom.dinero.model.FinancialObject;

public class Asset extends FinancialObject {

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Liability getAssociatedLiability() {
		return associatedLiability;
	}

	public void setAssociatedLiability(Liability associatedLiability) {
		this.associatedLiability = associatedLiability;
	}

	public Double getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(Double assetValue) {
		this.assetValue = assetValue;
	}

	public String getAssetLabel() {
		return assetLabel;
	}

	public void setAssetLabel(String assetLabel) {
		this.assetLabel = assetLabel;
	}

	public Asset(String assetId, String assetLabel, String finObjIdentifier, Double assetValue) {
		this.assetId = assetId;
		this.assetValue = assetValue;
		this.associatedLiability = new Liability(assetId, assetLabel, finObjIdentifier, assetValue, null);
		super.setFinObjIdentifier(finObjIdentifier);
		super.setCashflows(new ArrayList<Cashflow>());
	}

	public Asset(String assetId, String assetLabel, String finObjIdentifier, Double assetValue,
			ArrayList<Cashflow> cashflows) {
		this.assetId = assetId;
		this.assetValue = assetValue;
		this.associatedLiability = new Liability(assetId, assetLabel, finObjIdentifier, assetValue, null);
		super.setFinObjIdentifier(finObjIdentifier);
		super.setCashflows(cashflows);
	}

	private String assetId;
	private String assetLabel;
	private Liability associatedLiability;
	private Double assetValue;

}
