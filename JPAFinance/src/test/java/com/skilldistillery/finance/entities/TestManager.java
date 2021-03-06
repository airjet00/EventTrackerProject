package com.skilldistillery.finance.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestManager {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Manager manager;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("FinancePU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		manager = em.find(Manager.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		manager = null;
	}

	@Test
	@DisplayName("Testing fields in manager")
	void test1() {

		assertNotNull(manager);
		assertEquals("Erik", manager.getFirstName());
		assertEquals("admin", manager.getUsername());
		assertEquals(false, manager.isGoalAchieved());
	
	}

	@Test
	@DisplayName("Testing manager to expenses mapping")
	void test2() {

		assertNotNull(manager);
		assertEquals(1, manager.getExpenses().get(0).getId());
		assertEquals(100, manager.getExpenses().get(0).getAmount());
	
	}
	@Test
	@DisplayName("Testing manager to income mapping")
	void test3() {

		assertNotNull(manager);
		assertEquals("Google Income", manager.getIncomes().get(0).getDescription());
		assertEquals(10000, manager.getIncomes().get(0).getTotal());
	
	}
}
