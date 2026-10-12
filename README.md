# QA Portfolio

**Prasanga Niraula** · QA Engineer · Lalitpur / Kathmandu, Nepal · [prasanganiraula2016@gmail.com](mailto:prasanganiraula2016@gmail.com)

Manual, UI automation, API and performance testing work from the QA & Automation program at [TechAxis](https://techaxis.com.np/).

## Projects

| Area | Project | Highlights |
| --- | --- | --- |
| [Manual testing](01-manual-testing/) | Daraz search & filter | 17 scenarios and 36 test cases written from a requirements spec |
| | Login & auth security | 9 scenarios and 16 test cases, including lockout, session timeout, SQL injection and XSS |
| [UI automation](02-ui-automation/) | SauceDemo | Page Object Model, 9-case login decision table, headless Chrome |
| | Automation Exercise | Page Object Model, ExtentReports with failure screenshots, emailed report |
| [API testing](03-api-testing/) | Platzi Fake Store API | 14 Postman requests: CRUD, request chaining, JWT auth, JSON Schema check |
| [Performance testing](04-performance-testing/) | RemoteAxle login & profile APIs | JMeter, 5 load scenarios up to 20,000 samples |

## Tools

Java 21 · Selenium WebDriver 4.47 · TestNG 7.12 · Maven · ExtentReports 5 · Postman · Newman · Apache JMeter 5.6 · Git

## Running the tests

```bash
# UI automation: needs JDK 21+, Maven and Chrome. Run from either suite directory.
mvn clean test

# API: needs Node.js and Newman (npm install -g newman)
newman run 03-api-testing/platzi-fake-store-api.postman_collection.json

# Performance: needs Apache JMeter 5.6+
jmeter -n -t 04-performance-testing/remoteaxle-auth-load-test.jmx -l results.jtl -e -o report
```
