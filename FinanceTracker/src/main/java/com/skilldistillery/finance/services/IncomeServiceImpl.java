package com.skilldistillery.finance.services;

import java.util.List;
import java.util.Optional;

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
		
		Optional<Income> income = repo.findById(incomeId);
		if(income.isPresent()) {
			return income.get();
		}
		return null;

	}

	@Override
	public Income create(Income income) {
		
		repo.saveAndFlush(income);
			
		return income;
	}

	@Override
	public Income update(int id, Income income) {

		Income newIncome = retrieveIncome(id);
		if(newIncome != null) {
			newIncome.setDescription(income.getDescription());
			newIncome.setTotal(income.getTotal());
			newIncome.setPassive(income.isPassive());
			newIncome.setDateCreated(income.getDateCreated());
			newIncome.setActive(income.isActive());
			repo.saveAndFlush(newIncome);
			return newIncome;
		}
		
		return null;
	}

	@Override
	public void delete(int id) {

		repo.deleteById(id);
		
	}

}


