package com.skilldistillery.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.finance.entities.Expense;
import com.skilldistillery.finance.services.ExpenseService;

@RequestMapping("api")
@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService svc;
	
	@GetMapping("expense")
	public List<Expense> listExpense(){
		return svc.allExpense();
	}
	
}
