package com.skilldistillery.finance.services;

import java.util.List;

import com.skilldistillery.finance.entities.Income;

public interface IncomeService {

	public List<Income> allIncome();
	
	public Income retrieveIncome(int incomeId);
	
	public Income create(Income income);

	public Income update(int id, Income income);

	public void delete(int id);
}
