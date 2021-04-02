package com.skilldistillery.finance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.finance.entities.Income;
import com.skilldistillery.finance.repositories.IncomeRepository;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeRepository repo;
	
	@Override
	public List<Income> allIncome() {
		return repo.findAll();
	}

	@Override
	public Income retrieveIncome(int incomeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
