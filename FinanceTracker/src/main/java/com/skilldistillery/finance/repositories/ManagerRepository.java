package com.skilldistillery.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.finance.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
