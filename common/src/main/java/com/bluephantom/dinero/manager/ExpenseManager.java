package com.bluephantom.dinero.manager;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluephantom.dinero.model.FinancialValuation;
import com.bluephantom.dinero.vo.Expense;

public class ExpenseManager implements FinancialValuation {

	private static final Logger logger = LogManager.getLogger(ExpenseManager.class);

	private ExpenseManager() {
		this.expenses = new ArrayList<Expense>();
	}

	public static ExpenseManager getInstance() {
		if (instance == null) {
			instance = new ExpenseManager();
		}
		return instance;
	}

	public ArrayList<Expense> getExpenses() {
		return expenses;
	}

	public void addExpense(Expense expense) {
		this.expenses.add(expense);
	}

	public void removeExpense(Expense expense) {
		this.expenses.remove(expense);
	}

	public void addExpenses(ArrayList<Expense> expenses) {
		this.expenses.addAll(expenses);
	}

	public void removeExpenses(ArrayList<Expense> expenses) {
		this.expenses.removeAll(expenses);
	}

	@Override
	public Double valuation() {
		Double localValue = 0.0;
		if (!this.expenses.equals(null)) {
			localValue = expenses.stream().mapToDouble(expense -> expense.valuation()).sum();
		}
		logger.debug("valuation >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	private ArrayList<Expense> expenses;
	private static ExpenseManager instance;

}
