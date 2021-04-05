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
	
	@GetMapping("manager/{id}")
	public Manager showManager(@PathVariable int id) {
		return svc.retrieveManager(id);
	}

	@PostMapping("manager")
	public Manager create(@RequestBody Manager manager) {
		return svc.create(manager);
	}
	
	@PutMapping("manager/{id}")
	public Manager update(@PathVariable int id, @RequestBody Manager manager) {
		return svc.update(id, manager);
	}
	
	@DeleteMapping("manager/{id}")
	public void delete(@PathVariable int id) {
		svc.delete(id);
	}
	
}




