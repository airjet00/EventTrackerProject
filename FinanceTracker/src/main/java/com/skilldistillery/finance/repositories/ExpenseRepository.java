package com.skilldistillery.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.finance.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
