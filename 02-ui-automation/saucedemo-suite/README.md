# SauceDemo Suite

Selenium + TestNG tests for login, cart and checkout on [SauceDemo](https://www.saucedemo.com/).

## Login tests

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

## Cart tests

`CartAutomation` logs in as `visual_user`. All of its tests are tagged `regression`, and the checkout test is also tagged `smoke`.

| Test | Checks |
| --- | --- |
| `validateLoginAndCartHeroText` | Login opens the Products page, and the cart opens "Your Cart" |
| `testCheckoutFeature` | With every product added, checkout opens "Checkout: Your Information" |
| `verifyCorrectProductsAppearInCart` | Every product added shows up in the cart |
| `removeButtonCheck` | Removing every item leaves the cart empty |
| `testContinueShoppingBtn` | Continue Shopping returns to the Products page |
| `emptyCartCheckOut` | Checkout is blocked when the cart is empty |
| `productTitleBtnCheck` | Each product title in the cart opens that product's page |

## Structure

```text
src/test/java/
├── Base/BaseClass.java           # Chrome setup and teardown for each test
├── Pages/
│   ├── LoginPage.java            # login fields, error message
│   ├── ProductPage.java          # product list, add to cart
│   └── CartPage.java             # cart items, remove, checkout
└── TestCases/
    ├── LoginTestCases.java
    └── CartAutomation.java
```

## Run

```bash
mvn clean test   # runs testng.xml (login tests, then cart tests)
```
