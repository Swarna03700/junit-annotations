# JUnit Annotations

This repository documents my experimentation with **JUnit 5 (Jupiter)** annotations. The project is structured into "Micro-Labs", where each lab focuses on mastering a specific annotation through practical coding tasks.

## 🛠️ Tech Stacks

- **Language:** Java 17+
- **Testing Framework:** JUnit 5 (Jupiter)
- **Build Tool:** Gradle

## Labs
- [Lab 1: The Standard Unit](#-lab-1-the-standard-unit-test)
- [Lab 2: Data-Driven Testing](#-lab-2-data-driven-testing-parameterizedtest)
- [Lab 3: Stress and Stability Testing](#-lab-3-stress--stability-testing-repeatedtest)
- [Lab 4: Test Lifecycle](#-lab-4-test-lifecycle-beforeeach-beforeall-etc)

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

## 🧪 Lab 4: Test Lifecycle (`@BeforeEach, @BeforeAll, etc.)

**Goal:** How to manage test setup and teardown effectively to ensure tests are isolated and efficient.

**Scenario:** Simulated a `SimpleServer` that requires an expensive connection (booting up) and a clean state (empty data) for every test.

**Implementation**

**Logic:**

```Java
public class SimpleServer {

	private List<String> data = new ArrayList<>();

	public void connect() {
		System.out.println("Server connecting ...");
	}

	public void disconnect() {
		System.out.println("Server disconnecting ...");
	}

	public void addData(String item) {
		data.add(item);
	}

	public void clearData() {
		data.clear();
	}

	public int countItems() {
		return data.size();
	}
}
```

**Test:**

```Java
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
```
💡 **Key Takeway:** 
- Use `@BeforeEach` to ensure test **Isolation**.
- Use `@BeforeAll` for **Performance** (Don't restart the whole server/ database for every single test)
- `@BeforeAll` and `@AfterAll` methods must be **static**.

