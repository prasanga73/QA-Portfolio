package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject {

    public WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private By loginHeading = By.cssSelector("div.login-form h2");
    private By email = By.xpath("//input[@data-qa='login-email']");
    private By password = By.name("password");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loggedInUserName = By.xpath("//b[normalize-space()='Preksha Neupane']");
    private By logoutButton = By.cssSelector("a[href='/logout']");
    private By invalidMessage = By.xpath("//p[text()='Your email or password is incorrect!']");


    public String verifyLoginHeading() {
        return driver.findElement(loginHeading).getText();
    }

    public void enterEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String verifyLoggedInUser() {
        return driver.findElement(loggedInUserName).getText();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public String verifyInvalidLogin() {
        return driver.findElement(invalidMessage).getText();
    }
}