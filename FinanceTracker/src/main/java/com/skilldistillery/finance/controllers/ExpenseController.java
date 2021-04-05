package com.skilldistillery.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("expense/{id}")
	public Expense show(@PathVariable int id) {
		return svc.retrieveExpense(id);
	}
	
	@PostMapping("expense")
	public Expense create(@RequestBody Expense expense) {
		return svc.create(expense);
	}
	
	@PutMapping("expense/{id}")
	public Expense update(@PathVariable int id, @RequestBody Expense expense) {
		return svc.update(id, expense);
	}
	
	@DeleteMapping("expense/{id}")
	public void delete(@PathVariable int id) {
		svc.delete(id);
		
	}
	
}
