package com.bluephantom.dinero.manager;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluephantom.dinero.model.FinancialValuation;
import com.bluephantom.dinero.vo.Asset;
import com.bluephantom.dinero.vo.Income;

public class IncomeManager implements FinancialValuation {

	private static final Logger logger = LogManager.getLogger(IncomeManager.class);

	private IncomeManager() {
		this.incomes = new ArrayList<Income>();
		this.assets = new ArrayList<Asset>();
	}

	public static IncomeManager getInstance() {
		if (instance == null) {
			instance = new IncomeManager();
		}
		return instance;
	}

	public ArrayList<Income> getIncomes() {
		return incomes;
	}

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public void addIncome(Income income) {
		this.incomes.add(income);
	}

	public void removeIncome(Income income) {
		this.incomes.remove(income);
	}

	public void addIncomes(ArrayList<Income> incomes) {
		this.incomes.addAll(incomes);
	}

	public void removeIncomes(ArrayList<Income> incomes) {
		this.incomes.removeAll(incomes);
	}

	public void addAsset(Asset asset) {
		this.assets.add(asset);
	}

	public void removeAsset(Asset asset) {
		this.assets.remove(asset);
	}

	public void addAssets(ArrayList<Asset> assets) {
		this.assets.addAll(assets);
	}

	public void removeAssets(ArrayList<Asset> assets) {
		this.assets.removeAll(assets);
	}

	public Double valuationFromIncomes() {
		Double localValue = 0.0;
		if (!this.incomes.equals(null)) {
			localValue = incomes.stream().mapToDouble(income -> income.valuation()).sum();
		}
		logger.debug("valuationFromIncomes >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	public Double valuationFromAssets() {
		Double localValue = 0.0;
		if (!this.assets.equals(null)) {
			localValue = assets.stream().mapToDouble(asset -> asset.valuation()).sum();
		}
		logger.debug("valuationFromAssets >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	@Override
	public Double valuation() {
		Double localValue = valuationFromIncomes() + valuationFromAssets();
		logger.debug("valuation >> Returning valuation of : " + localValue.toString());
		return localValue;
	}

	private ArrayList<Income> incomes;
	private ArrayList<Asset> assets;
	private static IncomeManager instance;

}
