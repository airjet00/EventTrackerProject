package com.skilldistillery.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.finance.entities.Income;
import com.skilldistillery.finance.services.IncomeService;

@RequestMapping("api")
@RestController
public class IncomeController {

	@Autowired
	private IncomeService svc; 
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("income")
	public List<Income>  listIncome(){
		return svc.allIncome();
	}
}
