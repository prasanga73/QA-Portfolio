# UI Automation

Two Maven projects using Java, Selenium WebDriver and TestNG. Both use the Page Object Model: page classes hold locators and actions, and test classes hold the assertions.

| Suite | Target | Tests | Highlights |
| --- | --- | ---: | --- |
| [saucedemo-suite](saucedemo-suite/) | [SauceDemo](https://www.saucedemo.com/) | 11 | Login decision table, cart add/remove, headless Chrome |
| [automation-exercise-suite](automation-exercise-suite/) | [Automation Exercise](https://automationexercise.com/) | 5 | Register, login, logout; ExtentReports with failure screenshots, emailed report |

## Stack

Java 21 · Selenium WebDriver 4.47 · TestNG 7.12 · ExtentReports 5.1 · Maven Surefire · Chrome (driver resolved by Selenium Manager)

## Run

Needs JDK 21+, Maven and Chrome. From either suite directory:

```bash
mvn clean test
```

Each `pom.xml` points Surefire at the suite's TestNG XML file, so no extra flags are needed.
