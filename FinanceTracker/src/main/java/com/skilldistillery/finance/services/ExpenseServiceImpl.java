package com.skilldistillery.finance.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
