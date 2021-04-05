package com.skilldistillery.finance.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.finance.entities.Manager;
import com.skilldistillery.finance.repositories.ManagerRepository;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository repo;
	
	@Override
	public List<Manager> allManagers() {

		return repo.findAll();
	}

	@Override
	public Manager retrieveManager(int managerId) {
		
		Optional<Manager> manager = repo.findById(managerId);
		if(manager.isPresent()) {
			return manager.get();
		}
		
		return null;
	}

	@Override
	public Manager create(Manager manager) {

		repo.saveAndFlush(manager);
		
		return manager;
	}

	@Override
	public Manager update(int id, Manager manager) {

		Manager updateManager = retrieveManager(id);
		if(updateManager != null) {
			updateManager.setFirstName(manager.getFirstName());
			updateManager.setLastName(manager.getLastName());
			updateManager.setUsername(manager.getUsername());
			updateManager.setPassword(manager.getPassword());
			updateManager.setProfileUrl(manager.getProfileUrl());
			updateManager.setGoal(manager.getGoal());
			updateManager.setGoalAchieved(manager.isGoalAchieved());
			updateManager.setTotalAvailable(manager.getTotalAvailable());
			repo.saveAndFlush(updateManager);
			return updateManager;
		}
		
		return null;
	}

	@Override
	public void delete(int id) {
		
		repo.deleteById(id);
	}

}
