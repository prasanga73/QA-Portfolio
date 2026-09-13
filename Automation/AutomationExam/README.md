# SauceDemo Automation Exam

This Maven project contains a Selenium WebDriver and TestNG automation suite for [SauceDemo](https://www.saucedemo.com/). The suite demonstrates Page Object Model design, decision-table login coverage, cart state validation, and headless browser execution suitable for CI environments.

## Project Structure

```text
AutomationExam/
├── pom.xml
├── testng.xml
└── src/test/java/AutomationExam/
	├── BaseClass/BaseClass.java
	├── Pages/LoginPage.java
	├── Pages/CartPage.java
	└── TestCases/
		├── LoginTestCases.java
		└── CartTestCases.java
```

## Coverage

- Valid, invalid, and empty username/password combinations
- Login error-message assertions
- Adding and removing products from the cart
- Headless Chrome execution with CI-friendly browser options
- ExtentReports test reporting

## Technology Stack

- Java 21 compiler target
- Selenium WebDriver 4.47.0
- TestNG 7.12.0
- Apache Maven
- ExtentReports 5.1.2

## Run the Tests

From this directory, run:

```bash
mvn clean test
```

The Maven Surefire plugin uses `testng.xml` as the suite configuration.
