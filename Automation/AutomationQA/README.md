# 🛠️ Automation QA Training Workspace

This repository serves as a structured workspace containing learning exercises, assignments, and test automation scripts developed during the **Software Quality Assurance (QA) & Automation** course at [TechAxis](https://techaxis.com.np/) (Kumaripati, Lalitpur, Nepal).

---

## 📂 Project Modules

The workspace is organized into two core modules:

### 1. ☕ `JavaBasics/`
Focuses on core Java programming fundamentals and Object-Oriented Programming (OOP) concepts (Inheritance, Polymorphism, Abstraction, and Encapsulation) through practical class design and homework assignments.

### 2. 🧪 `AutomationExercises/`
A Maven-based test automation project targeting the [Automation Exercise](https://automationexercise.com) web application using Selenium WebDriver and TestNG.
*   **Daily Practice (`Day1` - `Day4`)**: Hands-on exercises covering browser setup (including Brave and Chrome), basic Selenium actions, TestNG annotations, and an initial introduction to the Page Object Model.
*   **Without POM Test Cases**: Baseline procedural scripts demonstrating direct page interaction and locator strategies.
*   **Using POM Test Cases**: Production-ready automation scripts structured around the **Page Object Model (POM)** pattern. Page locators and actions are decoupled from test scripts, and executions are orchestrated via a centralized TestNG suite.

---

## ⚡ Tech Stack

*   **Language:** Java
*   **Web Automation:** Selenium WebDriver
*   **Testing Framework:** TestNG
*   **Build Tool:** Maven

---

## 🚀 Getting Started & Execution

### Prerequisites
*   Java Development Kit (JDK 17 or higher)
*   Apache Maven
*   Chrome or Brave Browser

### Running the Automation Tests
Navigate to the automation module directory and execute the tests:

```bash
cd AutomationExercises
```

*   **Run all tests:**
    ```bash
    mvn clean test
    ```
*   **Run via TestNG Suite configuration (POM Tests):**
    ```bash
    mvn test -DsuiteXmlFile=src/test/java/AutomationTestCases/UsingPOM/testing.xml
    ```