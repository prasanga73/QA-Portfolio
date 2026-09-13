# Automation Exercise Test Suite

This Maven project contains Selenium WebDriver and TestNG exercises for [Automation Exercise](https://automationexercise.com/). It records the progression from direct procedural scripts to a reusable Page Object Model (POM) framework with reporting and failure screenshots.

## Project Structure

```text
AutomationExercises/
├── pom.xml
├── testing.xml
├── reports/                 # Generated ExtentReports HTML files
└── src/test/java/
	├── Day1/                # Browser setup and Brave workaround
	├── Day2/                # Basic Selenium interactions
	├── Day3/                # TestNG login exercises
	├── Day4/                # Introductory Page Object Model
	└── AutomationTestCases/
		├── WithoutPOM/      # Procedural registration and login tests
		└── UsingPOM/        # Reusable pages, tests, and utilities
```

## POM Test Coverage

- New user registration
- Valid user login
- Invalid login validation
- User logout
- Existing-user registration validation

The `UsingPOM/Utilities` package contains the TestNG listener, ExtentReports configuration, failure screenshot capture, and unique email generation helpers.

## Technology Stack

- Java 21 compiler target
- Selenium WebDriver 4.47.0
- TestNG 7.12.0
- Apache Maven
- ExtentReports 5.1.2
- Jakarta Mail 2.0.2

## Run the Tests

From this directory, run the configured Maven suite:

```bash
mvn clean test
```

To invoke the POM suite explicitly:

```bash
mvn test -DsuiteXmlFile=testing.xml
```

Reports are written to the `reports/` directory after execution.
