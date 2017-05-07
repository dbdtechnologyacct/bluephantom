package com.bluephantom.dinero.manager;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluephantom.dinero.model.FinancialValuation;
import com.bluephantom.dinero.vo.BankAccount;

public class CashManager implements FinancialValuation {

	private static final Logger logger = LogManager.getLogger(CashManager.class);

	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	private CashManager() {
		this.bankAccounts = new ArrayList<BankAccount>();
	}

	public static CashManager getInstance() {
		if (instance == null) {
			instance = new CashManager();
		}
		return instance;
	}

	public void addBankAccount(BankAccount account) {
		this.bankAccounts.add(account);
	}

	public void removeBankAccount(BankAccount account) {
		this.bankAccounts.remove(account);
	}

	public void addBankAccounts(ArrayList<BankAccount> accounts) {
		this.bankAccounts.addAll(accounts);
	}

	public void removeBankAccounts(ArrayList<BankAccount> accounts) {
		this.bankAccounts.removeAll(accounts);
	}

	@Override
	public Double valuation() {
		Double localValue = 0.0;
		if (!this.bankAccounts.equals(null)) {
			localValue = bankAccounts.stream().mapToDouble(bankAccount -> bankAccount.valuation()).sum();
		}
		logger.debug("valuation >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	private ArrayList<BankAccount> bankAccounts;
	private static CashManager instance;

}
