package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;

public class TestRandomNumbers {
	
	@RepeatedTest(100) // Denotes that a method is a test template for a repeated test
	void shouldGetNumbersGreaterThanZeroAndLessThanSeven() {
		RandomNumbers game = new RandomNumbers();
		
		int result = game.rollDice();
		
		assertTrue(result >= 1, "Value was too low: "+ result);
		assertTrue(result <= 6, "value was too high: "+ result);
	}
}
