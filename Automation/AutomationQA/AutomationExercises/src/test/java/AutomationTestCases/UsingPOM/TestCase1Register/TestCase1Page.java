package AutomationTestCases.UsingPOM.TestCase1Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCase1Page {
    public WebDriver driver;
    private WebDriverWait wait;

    public TestCase1Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By loginBtn = By.cssSelector("a[href='/login']");
    private By signupText = By.cssSelector("div[class='signup-form'] h2");
    private By name = By.cssSelector("input[placeholder='Name']");
    private By email = By.cssSelector("input[data-qa='signup-email']");
    private By signupBtn = By.cssSelector("button[data-qa='signup-button']");
    private By accountInfoText = By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > b:nth-child(1)");
    private By genderMr = By.id("id_gender1");
    private By password = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newsletter = By.id("newsletter");
    private By optin = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
    private By accountCreated = By.cssSelector("h2[data-qa='account-created']");
    private By continueBtn = By.cssSelector("a[data-qa='continue-button']");
    private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private By deleteAccountBtn = By.linkText("Delete Account");
    private By accountDeleted = By.cssSelector("h2[data-qa='account-deleted']");

    public void clickLoginLink() {
        driver.findElement(loginBtn).click();
    }

    public String getSignupText() {
        return driver.findElement(signupText).getText();
    }

    public void enterSignupDetails(String userName, String userEmail) {
        driver.findElement(name).sendKeys(userName);
        driver.findElement(email).sendKeys(userEmail);
    }

    public void clickSignup() {
        driver.findElement(signupBtn).click();
    }

    public String getAccountInfoText() {
        return driver.findElement(accountInfoText).getText();
    }

    public void fillAccountInformation(String pass, String day, String month, String year) {
        driver.findElement(genderMr).click();
        driver.findElement(password).sendKeys(pass);
        new Select(driver.findElement(days)).selectByValue(day);
        new Select(driver.findElement(months)).selectByValue(month);
        new Select(driver.findElement(years)).selectByValue(year);
        driver.findElement(newsletter).click();
        driver.findElement(optin).click();
    }

    public void fillAddressInformation(String first, String last, String comp, String addr1, String addr2, String ctry, String st, String cy, String zip, String mobile) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(company).sendKeys(comp);
        driver.findElement(address1).sendKeys(addr1);
        driver.findElement(address2).sendKeys(addr2);
        new Select(driver.findElement(country)).selectByVisibleText(ctry);
        driver.findElement(state).sendKeys(st);
        driver.findElement(city).sendKeys(cy);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(mobileNumber).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public String getAccountCreatedText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreated)).getText();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public String getLoggedInAsText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAs)).getText();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }

    public String getAccountDeletedText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeleted)).getText();
    }
}
