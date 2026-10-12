# Manual Testing

Test scenarios and test cases written in Excel. Each test case has an ID, its scenario and requirement IDs, preconditions, steps, test data and expected result.

## Daraz search & filter

Written from the [requirements spec](daraz-search-feature/Requirements_Daraz_Search_Feature-239963.pdf) for product search on [Daraz.com.np](https://www.daraz.com.np/). [`DarazTestCases.xlsx`](daraz-search-feature/DarazTestCases.xlsx) has 17 scenarios (one per requirement) and 36 test cases.

Covers:
- Search bar, searching with Enter or the search icon, auto-suggestions
- Keyword matching, case-insensitive search, zero-results behavior
- Filters for price range, brand, rating, location and free shipping; combined filters; clearing and resetting filters
- Sorting by popularity, price, newest and top rating
- Product card content, pagination, opening a product, keyword kept after search

## Login & auth security

[`LoginAuthTestCases.xlsx`](login-auth-security/LoginAuthTestCases.xlsx) has 9 scenarios and 16 test cases. Test data is in [`login-test-data.csv`](login-auth-security/login-test-data.csv).

Covers:
- Login with a valid username or email, and errors for invalid credentials
- Required fields, password masking, Forgot Password link, login page UI
- Account lockout after repeated failed attempts, session timeout after inactivity
- SQL injection and XSS in the username and password fields
