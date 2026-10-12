# SauceDemo Suite

Selenium + TestNG tests for [SauceDemo](https://www.saucedemo.com/). They run in headless Chrome, so they work on CI servers without a display.

## Tests

`LoginTestCases` covers every combination of valid, invalid and empty username and password. Each error message starts with "Epic sadface:".

| Username | Password | Expected |
| --- | --- | --- |
| Valid | Valid | Products page opens |
| Valid | Invalid | Username and password do not match any user in this service |
| Valid | Empty | Password is required |
| Invalid | Valid | Username and password do not match any user in this service |
| Invalid | Invalid | Username and password do not match any user in this service |
| Invalid | Empty | Password is required |
| Empty | Valid | Username is required |
| Empty | Invalid | Username is required |
| Empty | Empty | Username is required |

`CartTestCases` adds a product and checks that its button changes to "Remove". It then removes the product and checks that the button changes back to "Add to cart".

## Structure

```text
src/test/java/AutomationExam/
├── BaseClass/BaseClass.java   # headless Chrome setup and teardown
├── Pages/LoginPage.java       # login locators and actions
├── Pages/CartPage.java        # cart locators and actions
└── TestCases/
    ├── LoginTestCases.java
    └── CartTestCases.java
```

## Run

```bash
mvn clean test   # runs testng.xml
```
