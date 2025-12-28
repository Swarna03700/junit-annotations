package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestStringManipulator {
	
	@Test  // Denotes that a method is a test method
	void reverseAString() {
		StringManipulator sm = new StringManipulator();
		assertEquals("avaj", sm.reverse("java"));
	}
	
	// @Test
	@ParameterizedTest  // Denotes that a method is a parameterized test
	@ValueSource(strings = {"racecar", "radar", "madam"})  // used to provide data
	void checkPalindrome(String input) {
		StringManipulator sm = new StringManipulator();
		
//		assertTrue(sm.isPalindrome("racecar"));
//		assertTrue(sm.isPalindrome("radar"));
//		assertTrue(sm.isPalindrome("madam"));
		
		assertTrue(sm.isPalindrome(input));
	}
}


