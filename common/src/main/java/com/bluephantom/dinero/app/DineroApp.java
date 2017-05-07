package com.bluephantom.dinero.app;

import java.util.ArrayList;

import com.bluephantom.dinero.manager.CashManager;
import com.bluephantom.dinero.manager.ExpenseManager;
import com.bluephantom.dinero.manager.IncomeManager;
import com.bluephantom.dinero.vo.Asset;
import com.bluephantom.dinero.vo.BankAccount;
import com.bluephantom.dinero.vo.Expense;
import com.bluephantom.dinero.vo.Income;

public class DineroApp {

	private DineroApp() {
		this.cashManager = CashManager.getInstance();
		this.expenseManager = ExpenseManager.getInstance();
		this.incomeManager = IncomeManager.getInstance();
	}

	public static DineroApp getInstance() {
		if (instance == null) {
			instance = new DineroApp();
		}
		return instance;
	}

	public CashManager getCashManager() {
		return cashManager;
	}

	public void setCashManager(CashManager cashManager) {
		this.cashManager = cashManager;
	}

	public ExpenseManager getExpenseManager() {
		return expenseManager;
	}

	public void setExpenseManager(ExpenseManager expenseManager) {
		this.expenseManager = expenseManager;
	}

	public IncomeManager getIncomeManager() {
		return incomeManager;
	}

	public void setIncomeManager(IncomeManager incomeManager) {
		this.incomeManager = incomeManager;
	}

	public void addAsset(Asset asset) {
		this.incomeManager.addAsset(asset);
	}

	public void removeAsset(Asset asset) {
		this.incomeManager.removeAsset(asset);
	}

	public void addAssets(ArrayList<Asset> assets) {
		this.incomeManager.addAssets(assets);
	}

	public void removeAssets(ArrayList<Asset> assets) {
		this.incomeManager.removeAssets(assets);
	}

	public void addIncome(Income income) {
		this.incomeManager.addIncome(income);
	}

	public void removeIncome(Income income) {
		this.incomeManager.removeIncome(income);
	}

	public void addIncomes(ArrayList<Income> incomes) {
		this.incomeManager.addIncomes(incomes);
	}

	public void removeIncomes(ArrayList<Income> incomes) {
		this.incomeManager.removeIncomes(incomes);
	}

	public void addExpense(Expense expense) {
		this.expenseManager.addExpense(expense);
	}

	public void removeExpense(Expense expense) {
		this.expenseManager.removeExpense(expense);
	}

	public void addExpenses(ArrayList<Expense> expenses) {
		this.expenseManager.addExpenses(expenses);
	}

	public void removeExpenses(ArrayList<Expense> expenses) {
		this.expenseManager.removeExpenses(expenses);
	}

	public void addBankAccount(BankAccount account) {
		this.cashManager.addBankAccount(account);
	}

	public void removeBankAccount(BankAccount account) {
		this.cashManager.removeBankAccount(account);
	}

	public void removeBankAccounts(ArrayList<BankAccount> accounts) {
		this.cashManager.removeBankAccounts(accounts);
	}

	public void addBankAccounts(ArrayList<BankAccount> accounts) {
		this.cashManager.addBankAccounts(accounts);
	}

	private CashManager cashManager;
	private ExpenseManager expenseManager;
	private IncomeManager incomeManager;
	private static DineroApp instance;

}
