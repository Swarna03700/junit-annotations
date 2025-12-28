package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleDemoTest {
	
	@BeforeAll
	static void setupGlobal() {
		System.out.println("@BeforeAll - DB created");
	}
	
	@BeforeEach
	void setupThisTest() {
		System.out.println("	@BeforeEach - Data list cleared");
	}
	
	@Test
	void testOne() {
		System.out.println("		🧪 Test 1 executed");
	}
	
	@Test
	void testTwo() {
		System.out.println("		🧪 Test 2 executed");
	}
	
	@AfterEach
	void tearDownThisTest() {
		System.out.println("	@AfterEach - Data reset");
	}
	
	@AfterAll
	static void tearDownGlobal() {
		System.out.println("@AfterAll - DB disconnected");
	}
}
