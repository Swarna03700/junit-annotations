package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleServerTest {
	
	static SimpleServer server;
	
	@BeforeAll
	static void init() {
		server = new SimpleServer();
		server.connect();
	}
	
	@BeforeEach
	void setup() {
		System.out.println("Clearing data ...");
		server.clearData();
	}
	
	@Test
	@DisplayName("Should add single item")
	void testAddOneItem() {
		System.out.println("Running test 1 🧪");
		server.addData("Item 1");
		assertEquals(1, server.countItems());
	}
	
	@Test
	@DisplayName("Should add two items")
	void testAddTwoItems() {
		System.out.println("Running test 2 🧪");
		server.addData("Item 1");
		server.addData("Item 2");
		assertEquals(2, server.countItems());
	}
	
	@AfterAll
	static void close() {
		server.disconnect();
	}
}
