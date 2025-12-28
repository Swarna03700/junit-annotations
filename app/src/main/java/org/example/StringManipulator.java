package org.example;

/**
 * The StringManipulator class has a method called reverse() which takes a
 * string as an input and reverse that string.
 */
public class StringManipulator {

	public String reverse(String input) {
		String val = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			val += input.charAt(i);
		}
		return val;
	}

	public boolean isPalindrome(String input) {
		if (input.equals(reverse(input)))
			return true;
		else
			return false;
	}
}
