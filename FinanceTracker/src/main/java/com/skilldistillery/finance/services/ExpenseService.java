package com.skilldistillery.finance.services;

import java.util.List;

import com.skilldistillery.finance.entities.Expense;

public interface ExpenseService {

	public List<Expense> allExpense();
	
	public Expense retrieveExpense(int expId);

	public Expense create(Expense expense);

	public Expense update(int id, Expense expense);

	public void delete(int id);
}
