package AutomationTestCases.UsingPOM.TestCase3InvalidLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase3Page {
    public WebDriver driver;

    public TestCase3Page(WebDriver driver) {
        this.driver = driver;
    }

    private By loginBtn = By.cssSelector("a[href='/login']");
    private By loginText = By.cssSelector("div[class='login-form'] h2");
    private By email = By.cssSelector("input[data-qa='login-email']");
    private By password = By.cssSelector("input[placeholder='Password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loggedText = By.cssSelector("li:nth-child(10) a:nth-child(1)");
    private By logginErrorText = By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > p:nth-child(4)");

    public void clickLoginLink() {
        driver.findElement(loginBtn).click();
    }

    public String getLoginText() {
        return driver.findElement(loginText).getText();
    }

    public void login(String userEmail, String userPassword) {
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(loginButton).click();
    }

    public String getLoginErrorText() {
        return driver.findElement(logginErrorText).getText();
    }

    public String getLoggedText() {
        return driver.findElement(loggedText).getText();
    }
}
