# JUnit Annotations

This repository documents my experimentation with **JUnit 5 (Jupiter)** annotations. The project is structured into "Micro-Labs", where each lab focuses on mastering a specific annotation through practical coding tasks.

## 🛠️ Tech Stacks

- **Language:** Java 17+
- **Testing Framework:** JUnit 5 (Jupiter)
- **Build Tool:** Gradle

## 🧪 Lab 1: The Standard Unit (`@Test`)

**Goal:** The atomic unit of testing using standard `@Test` annotation.

**Task:**
Create a class `StringManipulator` with a method `reverse(String input)`. Write a test to verify that `reverse("Java")` returns `"avaJ"`;

**Implementation**

**Logic:**

```Java
public String reverse(String input) {
    String val = "";
    for(int i = input.length() - 1; i >= 0; i--)
      val += input.charAt(i);
    return val;
}
```

**Test:**

```Java
@Test
void reverseAString() {
    StringManipulator sm = new StringManipulator();
    assertEquals("avaJ", sm.reverse("Java"));
}
```

💡 **Key Takeway:** `@Test` tells the compiler that the method is a test case.

## 🧪 Lab 2: Data-Driven Testing (`@ParameterizedTest`)

**Goal:** Learn to run the same test logic against multiple inputs to reduce code duplication.

**Task:** Add a method `isPalindrome(String input)` to your `StringManipulator`. Write a `@ParameterizedTest` using `@ValueSource(strings = {"racecar", "radar", "madam"})` to ensure all of them are true.

**Implementation**

**Logic:**

```Java
public boolean isPalindrome(String input) {
    if(input.equals(reverse(input)))
      return true;
    else
      return false;
}
```

**Test:**

```Java
@ParameterizedTest
@ValueSource(stings = {"racecar", "radar", "madam"})
void checkPalindrome(String input) {
    StringManipulator sm = new StringManipulator();
    assertTrue(sm.isPalindrome(input));
}
```

💡 **Key Takeway:** `@ParameterizedTest` helps to reduce code while testing against multiple inputs.

## 🧪 Lab 3: Stress & Stability Testing (`@RepeatedTest`)

**Goal:** Verify non-deterministic logic (randomness) by running a test multiple times automatically.

**Task:** Create a method `rollDice()` that returns a number between 1 and 6. Write a `@RepeatedTest(10)` to verify the result is always greater than 0 and less than 7.

**Implementation**

**Logic:**

```Java
public int rollDice() {
		return new Random().nextInt(6) + 1;
}
```

**Test:**

```Java
@RepeatedTest(100) // Denotes that a method is a test template for a repeated test
	void shouldGetNumbersGreaterThanZeroAndLessThanSeven() {
		RandomNumbers game = new RandomNumbers();

		int result = game.rollDice();

		assertTrue(result >= 1, "Value was too low: "+ result);
		assertTrue(result <= 6, "value was too high: "+ result);
}
```

💡 **Key Takeway:** `@RepeatedTest` is essential for testing "flaky" code, random generators, or potential concurrency issues where a bug might only appear 1 out of 100 times.
