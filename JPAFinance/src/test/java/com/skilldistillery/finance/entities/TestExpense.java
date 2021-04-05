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

class TestExpense {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Expense expense;
	
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
		expense = em.find(Expense.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		expense = null;
	}

	@Test
	@DisplayName("Testing fields in manager")
	void test1() {

		assertNotNull(expense);
		assertEquals(100, expense.getAmount());
		assertEquals("U.S. Bank", expense.getCompany());
		assertEquals(true, expense.isActive());
	
	}
	
	@Test
	@DisplayName("Testing Income mapping to manager")
	void test2() {

		assertNotNull(expense);
		assertEquals("Erik", expense.getManagerExp().getFirstName());
		assertEquals("admin", expense.getManagerExp().getPassword());
	
	}

}
