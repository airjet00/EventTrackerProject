package com.skilldistillery.finance.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

}
