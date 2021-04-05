package com.skilldistillery.finance.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestIncome {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Income income;
	
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
		income = em.find(Income.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		income = null;
	}

	@Test
	@DisplayName("Testing set up of hibernate")
	void test() {

		assertNotNull(income);
		assertEquals("Google Income", income.getDescription());
	
	}

	@Test
	@DisplayName("Testing fields in income")
	void test1() {

		assertNotNull(income);
		assertEquals("Google Income", income.getDescription());
		assertEquals(10000, income.getTotal());
		assertEquals(false, income.isPassive());
	
	}
	
	@Test
	@DisplayName("Testing income to manager mapping")
	void test2() {

		assertNotNull(income);
		assertEquals("Erik", income.getManagerInc().getFirstName());
		assertEquals("admin", income.getManagerInc().getPassword());
	
	}
}
