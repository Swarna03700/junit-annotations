package org.example;

import java.util.Random;

public class RandomNumbers {
	
	public int rollDice() {
		return new Random().nextInt(6) + 1;
	}
}
