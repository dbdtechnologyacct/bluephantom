package com.bluephantom.dinero.model;

public enum CashflowType {

	IN(1.0), OUT(-1.0);
	private Double sign;

	public Double getSign() {
		return sign;
	}

	private CashflowType(Double sign) {
		this.sign = sign;
	}

}
