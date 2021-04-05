package com.skilldistillery.finance.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.finance.entities.Expense;
import com.skilldistillery.finance.repositories.ExpenseRepository;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired 
	private ExpenseRepository repo;

	@Override
	public List<Expense> allExpense() {
		return repo.findAll();
	}

	@Override
	public Expense retrieveExpense(int expId) {

		Optional<Expense> expense = repo.findById(expId);
		if(expense.isPresent()) {
			return expense.get();
		}
		return null;
	}

	@Override
	public Expense create(Expense expense) {
		repo.saveAndFlush(expense);
		
		return expense;
	}

	@Override
	public Expense update(int id, Expense expense) {

		Expense updateExp = retrieveExpense(id);
		if(updateExp != null) {
			updateExp.setType(expense.getType());
			updateExp.setCompany(expense.getCompany());
			updateExp.setAmount(expense.getAmount());
			updateExp.setDueDate(expense.getDueDate());
			updateExp.setReacurring(expense.isReacurring());
			updateExp.setNote(expense.getNote());
			updateExp.setDateCreated(expense.getDateCreated());
			updateExp.setActive(expense.isActive());
			repo.saveAndFlush(updateExp);
			return updateExp;
		}
		
		return null;
	}

	@Override
	public void delete(int id) {

		repo.deleteById(id);;
	}
	
	
	
}
