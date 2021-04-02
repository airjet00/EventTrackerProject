package com.skilldistillery.finance.services;

import java.util.List;

import com.skilldistillery.finance.entities.Income;

public interface IncomeService {

	List<Income> allIncome();
	Income retrieveIncome(int incomeId);
}
