package com.skilldistillery.finance.services;

import java.util.List;

import com.skilldistillery.finance.entities.Manager;

public interface ManagerService {

	List<Manager> allManagers();
	
	Manager retrieveManager(int managerId);
}
