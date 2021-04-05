package com.skilldistillery.finance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.finance.entities.Manager;
import com.skilldistillery.finance.services.ManagerService;

@RequestMapping("api")
@RestController
public class ManagerController {

	@Autowired
	private ManagerService svc;
	
	@GetMapping("manager")
	public List<Manager> listManager(){
		return svc.allManagers();
	}
	
	
}
