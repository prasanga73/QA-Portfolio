# AutomationExercise Test Automation Suite

Selenium WebDriver and TestNG automation for [Automation Exercise](https://automationexercise.com/), built as a Maven project. The repository captures the progression from direct browser scripts to a reusable Page Object Model (POM) test architecture.

## AutomationExercise Suite

Multi-tier Maven automation architecture featuring dynamic test data generation, ExtentReports 5 dashboards, automated failure screenshots, and email report dispatch.

### Highlights

- **Dynamic email generation:** `EmailsUtils.java` creates timestamped, unique user emails so registration tests can run repeatedly without database collisions.
- **Automated failure capture:** `ExtentReporterManagerSS` captures PNG screenshots when a test fails and embeds them in the Extent HTML report.
- **Test lifecycle logging:** `CustomTestListener` logs suite, test-start, pass, failure, and skip events for console visibility.
- **Architectural evolution:** The project demonstrates migration from procedural baseline scripts in `WithoutPOM/` to structured enterprise-style tests in `UsingPOM/`.
- **Email dispatch:** The reporting listener can send the generated HTML report as an email attachment through Jakarta Mail.

## Test Coverage

The configured TestNG suite runs the following POM tests:

| Test | Scenario |
| --- | --- |
| `TestCase1RegisterUser` | Register a new user |
| `TestCase2ValidUserLogin` | Log in with valid credentials |
| `TestCase3InvalidUserLogin` | Validate invalid login behavior |
| `TestCase4UserLogOut` | Log out an authenticated user |
| `TestCase5ExistingRegister` | Validate registration for an existing user |

Each POM test uses `BaseClass` to start Chrome, open the application, apply browser settings, and close the driver after execution.

## Project Structure

```text
AutomationExercises/
├── pom.xml                         # Maven build and dependency configuration
├── testing.xml                     # TestNG suite and active listeners
├── reports/                        # Generated ExtentReports HTML files
├── screenshots/                    # Failure screenshots created at runtime
└── src/
	├── main/resources/             # Main-resource directory
	└── test/java/
		├── Day1/                   # Browser setup and Brave workaround
		├── Day2/                   # Basic Selenium interactions
		├── Day3/                   # TestNG login exercises
		├── Day4/                   # Introductory POM exercises
		└── AutomationTestCases/
			├── WithoutPOM/         # Procedural registration and login tests
			└── UsingPOM/
				├── BaseClass.java  # Shared browser setup and teardown
				├── TestCase1Register/
				├── TestCase2ValidLogin/
				├── TestCase3InvalidLogin/
				├── TestCase4LogOut/
				├── TestCase5RegisteredUser/
				└── Utilities/
					├── EmailsUtils.java
					├── CustomTestListener.java
					├── ExtentReporterManager.java
					└── ExtentReporterManagerSS.java
```

## Reporting Workflow

The active listener in `testing.xml` is `ExtentReporterManagerSS`:

1. Creates a timestamped Extent Spark HTML report in `reports/`.
2. Records passed, failed, and skipped TestNG methods.
3. Captures a browser screenshot for failed tests in `screenshots/`.
4. Embeds the screenshot path into the failed report entry.
5. Flushes the report and can email it as an attachment through `EmailsUtils`.

`ExtentReporterManager` provides the reporting flow without screenshots. `CustomTestListener` is available for console lifecycle logging and is currently commented out in the suite XML.

## Technology Stack

- Java compiler configuration: Maven compiler plugin with source and target set to Java 21
- Apache Maven
- Selenium WebDriver 4.47.0
- TestNG 7.12.0
- ExtentReports 5.1.2
- Lombok 1.18.38
- Jakarta Mail 2.0.2
- Google Chrome with Selenium Manager for driver resolution

## Prerequisites

- JDK 21 or a compatible newer JDK
- Apache Maven 3.8 or newer
- Google Chrome installed and available to Selenium
- Network access to `automationexercise.com`

Verify the local tools before running the suite:

```bash
java -version
mvn -version
```

## Run the Tests

Run the configured TestNG suite from the `AutomationExercises` directory:

```bash
mvn clean test
```

The Surefire plugin is already configured to use `testing.xml`. To select the suite explicitly:

```bash
mvn test -DsuiteXmlFile=testing.xml
```

Run a specific test class when troubleshooting:

```bash
mvn -Dtest=AutomationTestCases.UsingPOM.TestCase2ValidLogin.TestCase2ValidUserLogin test
```

## Output Locations

- Extent HTML reports: `reports/Test-Report-<timestamp>.html`
- Failure screenshots: `screenshots/<test-name>_<timestamp>.png`
- Maven build output: `target/`
- Surefire and TestNG result files: `target/surefire-reports/`

## Configuration and Security

The email utility currently contains SMTP sender and recipient settings in source code. Do not commit real passwords or app passwords. Before sharing or running this project in another environment, move those values to environment variables or another secret-management mechanism and update `EmailsUtils.java` to read them at runtime.

## Learning Path

The exercises are organized as a progression:

1. `Day1` and `Day2` introduce browser automation and Selenium interactions.
2. `Day3` introduces TestNG-based test execution.
3. `Day4` introduces the Page Object Model.
4. `WithoutPOM` shows direct procedural test implementations.
5. `UsingPOM` applies reusable setup, page objects, utilities, listeners, reporting, and test data generation.
