# 📋 Manual Testing & Quality Engineering Documentation

This module contains comprehensive test design documentation, requirement analyses, and test execution matrices developed across real-world e-commerce and enterprise authentication domains.

---

## 📂 Sub-Directories & Artifacts

| Module | Source Document | Test Artifact | Key Focus Areas |
| :--- | :--- | :--- | :--- |
| **Daraz Product Search** | [`Requirements_Daraz_Search_Feature-239963.pdf`](./Daraz%20Manual/Requirements_Daraz_Search_Feature-239963.pdf) | [`DarazTestCases.xlsx`](./Daraz%20Manual/DarazTestCases.xlsx) | Functional, UI, Filter Combination, Sorting, Responsive & Non-functional Testing |
| **Enterprise Auth & Security** | Industry Security Spec | [`AssignmentEdited.xlsx`](./Second/AssignmentEdited.xlsx) & [`apitest1.csv`](./Second/apitest1.csv) | Positive/Negative Login, Field Validations, Session Timeout, SQL Injection & XSS |

---

## 1. Daraz.com.np E-Commerce Search & Filter Feature

### Context
Derived from formal specification **`REQ-DZ-SEARCH-01` (v1.0)** for [Daraz.com.np](https://www.daraz.com.np/). The feature allows visitors to search products via keyword queries, inspect auto-suggestions, and refine catalog results using multi-attribute filters and sorting.

### Deliverables Breakdown

#### A. High-Level Test Scenarios (`TS-01` to `TS-21`)
- **`TS-01` to `TS-03`:** Search bar visibility across all site headers, Enter/Icon search invocation, and real-time auto-suggestions as user types.
- **`TS-04` to `TS-06`:** Query matching against Title, Brand, and Category; Case-insensitivity (`laptop` = `Laptop` = `LAPTOP`); "No results found" graceful empty state with alternative suggestions.
- **`TS-07` to `TS-10`:** Individual filters for Price Range (Min/Max validation), Brand filtering, Customer Rating threshold (e.g. 4+ stars), and Location/Free Shipping filters.
- **`TS-11` & `TS-12`:** Multi-filter compounding (applying 3+ filters simultaneously) and single-filter clear vs. "Reset All Filters".
- **`TS-13`:** Sorting verification across 5 algorithms: Popularity, Price (Low to High), Price (High to Low), Newest arrivals, and Top Rating.
- **`TS-14`:** Product card content verification: thumbnail image, title, active price, discount badge/percentage, and customer rating stars.
- **`TS-15` to `TS-17`:** Pagination navigation, product card click-through to detail page, and retention of searched keyword in the search bar.
- **`TS-18` to `TS-21` (Non-Functional):** Response time within 3 seconds, mobile/desktop responsiveness, special character/emoji sanitization, and leading/trailing whitespace trimming.

#### B. Granular Test Cases (`TC-01` to `TC-17d`)
Each test case is specified with:
- **Test Case ID & Scenario ID**
- **Title & Objective**
- **Preconditions** (e.g. site access, filter states)
- **Detailed Step-by-Step Test Steps**
- **Test Data Inputs**
- **Expected Results**
- **Priority** (High / Medium / Low) and **Status** (Pass / Fail)

#### C. Requirement Traceability Matrix (RTM)
Guarantees 100% bidirectional coverage between requirements (`REQ-01` through `REQ-21`), test scenarios, and executed test cases.

---

## 2. Enterprise Authentication & Security Test Suite

### Scope & Structure
Documented in [`AssignmentEdited.xlsx`](./Second/AssignmentEdited.xlsx), this suite targets core login functionality, user session lifecycles, and vulnerability defenses against common OWASP threats.

| Scenario ID | Test Case ID | Test Focus | Objective & Test Technique |
| :---: | :---: | :--- | :--- |
| **TS-01** | `TC-01`, `TC-01a`, `TC-01b` | Valid Login & Redirection | Valid username/email + password, verifies redirect to user dashboard. |
| **TS-02** | `TC-02`, `TC-02a`, `TC-02b` | Invalid Credentials | Invalid username, invalid password, mismatched pairs; validates generic security-safe error messaging. |
| **TS-03** | `TC-03`, `TC-03a` | Mandatory Fields | Blank username and blank password submissions; validates inline required field warnings. |
| **TS-04** | `TC-04` | Password Masking | Visual privacy check verifying entered characters render as bullets/asterisks. |
| **TS-05** | `TC-05` | Brute-Force Defense | Simulates consecutive failed login attempts to verify account lockout threshold activation. |
| **TS-06** | `TC-06`, `TC-06a` | Forgot Password Flow | Validates presence and routing of password reset link. |
| **TS-07** | `TC-07` | Session Inactivity Timeout | Verifies user session automatically invalidates after defined idle threshold. |
| **TS-08** | `TC-08` | UI Layout Integrity | Checks element rendering, alignment, and responsiveness on login portal. |
| **TS-09** | `TC-09` | **SQL Injection (SQLi)** | Injects `' OR 1=1 --` into inputs to test authentication bypass resilience. |
| **TS-09** | `TC-09a` | **Cross-Site Scripting (XSS)** | Injects `<script>alert('XSS')</script>` payloads to verify input sanitization. |

---

## 📊 Summary of Quality Engineering Principles Applied
- **Equivalence Partitioning & Boundary Value Analysis** used for range filters and input fields.
- **Defect Prevention** through early requirement analysis and edge-case scenario creation.
- **Traceability Management** guaranteeing that no business requirement is released without verified test coverage.
