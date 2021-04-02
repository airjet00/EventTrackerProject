package com.skilldistillery.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.finance.entities.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer> {

}
