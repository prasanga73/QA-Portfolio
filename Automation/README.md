# 🤖 Web UI Automation Engineering Frameworks

This directory houses production-ready test automation frameworks developed using **Java**, **Selenium WebDriver**, **TestNG**, and **Apache Maven**, showcasing enterprise architectural patterns, continuous testing, and advanced reporting.

---

## 🏛️ Framework Comparison & Overview

| Framework Project | Target System | Design Pattern | Key Capabilities |
| :--- | :--- | :--- | :--- |
| **AutomationExam** | [SauceDemo](https://www.saucedemo.com/) | Page Object Model (POM) | 9-case Auth Decision Table, Cart state transitions, Modern Headless Chrome (`--headless=new`), CI/CD & Jenkins-ready |
| **AutomationQA / AutomationExercises** | [Automation Exercise](https://automationexercise.com/) | Page Object Model (POM) + Listeners | Dynamic timestamped email generation (`EmailsUtils`), ExtentReports 5 with automatic failure screenshot capture, Jakarta Mail dispatch |

---

## 📁 1. Project A: SauceDemo CI/CD Suite (`AutomationExam/`)

### Architecture
```plaintext
AutomationExam/
├── pom.xml                                  # Maven dependencies: Selenium 4.47, TestNG 7.12, ExtentReports 5
├── testng.xml                               # Suite runner configuration
└── src/test/java/AutomationExam/
    ├── BaseClass/
    │   └── BaseClass.java                   # Headless driver initialization, wait timeouts, cookie teardown
    ├── Pages/
    │   ├── LoginPage.java                   # Locators & action methods for user login
    │   └── CartPage.java                    # Locators & action methods for inventory & cart
    └── TestCases/
        ├── LoginTestCases.java              # 9 Decision table test permutations
        └── CartTestCases.java               # Cart item add/remove state validation
```

### Key Highlights
1. **Decision Table Authentication Testing:**
   Covers every combination of valid, invalid, and missing credentials:
   - Valid User + Valid Password (`standard_user` + `secret_sauce` -> Passes and navigates to inventory)
   - Valid User + Invalid Password -> Exact assertion on error message: `"Epic sadface: Username and password do not match any user in this service"`
   - Valid User + Empty Password -> `"Epic sadface: Password is required"`
   - Invalid User + Valid Password -> `"Epic sadface: Username and password do not match any user in this service"`
   - Invalid User + Invalid Password -> Mismatch error assertion
   - Invalid User + Empty Password -> `"Epic sadface: Password is required"`
   - Empty User + Valid Password -> `"Epic sadface: Username is required"`
   - Empty User + Invalid Password -> `"Epic sadface: Username is required"`
   - Empty User + Empty Password -> `"Epic sadface: Username is required"`

2. **Headless Execution for CI/CD Pipelines:**
   `BaseClass.java` is pre-configured with flags essential for running inside Docker containers or Jenkins agents without a GUI:
   ```java
   ChromeOptions options = new ChromeOptions();
   options.addArguments("--headless=new");           // modern headless mode
   options.addArguments("--no-sandbox");             // required for root/jenkins execution
   options.addArguments("--disable-dev-shm-usage");  // prevents /dev/shm memory exhaustion in CI
   options.addArguments("--disable-gpu");
   options.addArguments("--window-size=1920,1080");
   ```

### Running the Suite:
```bash
cd AutomationExam
mvn clean test
```

---

## 📁 2. Project B: Automation Exercise Enterprise Suite (`AutomationQA/AutomationExercises/`)

### Architecture
```plaintext
AutomationExercises/
├── pom.xml                                  # Build configuration & surefire plugins
├── reports/                                 # Generated HTML test execution reports with embedded screenshots
└── src/test/java/
    ├── AutomationTestCases/
    │   ├── UsingPOM/                        # Enterprise Page Object Model implementation
    │   │   ├── BaseClass.java               # WebDriver lifecycle management
    │   │   ├── TestCase1Register/           # POM Page + Test for full user profile registration
    │   │   ├── TestCase2ValidLogin/         # POM Page + Test for authenticated user login
    │   │   ├── TestCase3InvalidLogin/       # POM Page + Test for negative credential validation
    │   │   ├── TestCase4LogOut/             # POM Page + Test for user session logout
    │   │   ├── TestCase5RegisteredUser/     # POM Page + Test for duplicate user registration
    │   │   └── Utilities/
    │   │       ├── CustomTestListener.java  # TestNG ITestListener implementation
    │   │       ├── ExtentReporterManagerSS.java # Automatic failure screenshot capture & linking
    │   │       ├── ExtentReporterManager.java   # ExtentReports 5 dashboard configuration
    │   │       └── EmailsUtils.java         # Dynamic email generator & Jakarta Mail sender
    │   └── WithoutPOM/                      # Procedural scripts highlighting framework evolution
    └── Day1..4/                             # Daily exercises, Brave browser workaround, locator experiments
```

### Key Highlights
1. **Dynamic Idempotent Test Data:**
   `EmailsUtils.java` generates timestamp-backed unique emails:
   ```java
   public static String generateUniqueEmail() {
       return "testuser" + System.currentTimeMillis() + "@gmail.com";
   }
   ```
   This ensures tests like `TestCase1RegisterUser` can run indefinitely in CI/CD without conflicting with existing database records.

2. **Automated Failure Screenshots in ExtentReports 5:**
   When any test method fails, `CustomTestListener` intercepts the failure via `onTestFailure`, triggers `ExtentReporterManagerSS.captureScreenshot(driver, result.getName())`, and attaches the resulting PNG file to the Extent HTML report.

3. **Email Notification Pipeline:**
   Includes automated email dispatch capabilities using Jakarta Mail (`EmailsUtils.java`) to send test execution summaries to team stakeholders upon build completion.

### Running the Suite:
```bash
cd AutomationQA/AutomationExercises
mvn test -DsuiteXmlFile=src/test/java/AutomationTestCases/UsingPOM/testing.xml
```
