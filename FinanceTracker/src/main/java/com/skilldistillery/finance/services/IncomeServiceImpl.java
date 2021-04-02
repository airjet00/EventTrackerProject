package com.skilldistillery.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.finance.entities.Income;
import com.skilldistillery.finance.repositories.FinanceRepository;

@Service
@Transactional
public class IncomeServiceImpl implements FinanceService {

	@Autowired
	private FinanceRepository repo;
	
	@Override
	public List<Income> allIncome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Income retrieveIncome(int incomeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
