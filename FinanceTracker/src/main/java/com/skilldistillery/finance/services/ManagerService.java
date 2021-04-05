package com.skilldistillery.finance.services;

import java.util.List;

import com.skilldistillery.finance.entities.Manager;

public interface ManagerService {

	public List<Manager> allManagers();
	
	public Manager retrieveManager(int managerId);

	public Manager create(Manager manager);

	public Manager update(int id, Manager manager);

	public void delete(int id);
}
