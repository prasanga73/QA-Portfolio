# Automation Exercise Suite

Selenium + TestNG tests for [Automation Exercise](https://automationexercise.com/), with ExtentReports reporting.

## Tests

| Test | Scenario |
| --- | --- |
| `TestCase1RegisterUser` | Register a new user |
| `TestCase2ValidUserLogin` | Log in with valid credentials |
| `TestCase3InvalidUserLogin` | Log in with invalid credentials |
| `TestCase4UserLogOut` | Log out |
| `TestCase5ExistingRegister` | Sign up with an email that is already registered |

## Reporting

`ExtentReporterManagerSS` is the listener set in `testing.xml`. On each run it:
1. Writes an HTML report to `reports/Test-Report-<timestamp>.html`
2. Saves a screenshot of each failed test to `screenshots/` and attaches it to the report
3. Emails the report when the suite finishes, using the sender settings in `EmailsUtils.java`

## Structure

```text
src/test/java/automationexercise/
├── BaseClass.java                   # opens Chrome before each test, quits after
├── TestCase1Register/ … TestCase5RegisteredUser/
│                                    # page class + test class per scenario
└── Utilities/
    ├── ExtentReporterManagerSS.java # report with failure screenshots (active)
    ├── ExtentReporterManager.java   # report without screenshots
    ├── CustomTestListener.java      # console logging (disabled in testing.xml)
    └── EmailsUtils.java             # emails the report
```

## Run

```bash
mvn clean test

# a single test class
mvn -Dtest=automationexercise.TestCase2ValidLogin.TestCase2ValidUserLogin test
```
