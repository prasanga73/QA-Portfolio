package AutomationTestCases.UsingPOM.TestCase5RegisteredUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase5Page {
    public WebDriver driver;

    public TestCase5Page(WebDriver driver) {
        this.driver = driver;
    }

    private By loginBtn = By.cssSelector("a[href='/login']");
    private By loginText = By.cssSelector("div[class='login-form'] h2");
    private By SignUpEmail = By.cssSelector("input[data-qa='signup-email']");
    private By username = By.cssSelector("input[placeholder='Name']");
    private By userSignUpText = By.cssSelector("div[class='signup-form'] h2");
    private By signupBtn = By.cssSelector("button[data-qa='signup-button']");
    private By ExistsMessage = By.xpath("//p[normalize-space()='Email Address already exist!']");



    public void clickLoginLink() {
        driver.findElement(loginBtn).click();
    }


    public void signup(String userEmail, String userName) {
        driver.findElement(SignUpEmail).sendKeys(userEmail);
        driver.findElement(username).sendKeys(userName);
        driver.findElement(signupBtn).click();
    }


    public String getSignupText() {
        return driver.findElement(userSignUpText).getText();
    }

    public String getUserExistsText() {
        return driver.findElement(ExistsMessage).getText();
    }


}
