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

import com.skilldistillery.finance.entities.Income;
import com.skilldistillery.finance.services.IncomeService;

@RequestMapping("api")
@RestController
public class IncomeController {

	@Autowired
	private IncomeService svc; 

	
//  *** PING TEST ***	
//	@GetMapping("ping")
//	public String ping() {
//		return "pong";
//	}
	
	@GetMapping("income")
	public List<Income>  listIncome(){
		return svc.allIncome();
	}
	
	@GetMapping("income/{id}")
	public Income show(@PathVariable int id) {
		return svc.retrieveIncome(id);
	}
	
	@PostMapping("income")
	public Income create(@RequestBody Income income) {
		return svc.create(income);
	}
	
	@PutMapping("income/{id}")
	public Income update(@PathVariable int id, @RequestBody Income income) {
		return svc.update(id, income);
	}
	
	@DeleteMapping("income/{id}")
	public void delete(@PathVariable int id) {
		svc.delete(id);
	}
}




