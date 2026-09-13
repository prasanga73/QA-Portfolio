package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private By homePage = By.xpath("//a[normalize-space()='Home']");
    private By signLogin = By.xpath("//a[normalize-space()='Signup / Login']");

    public void verifyHomePage(String expected) {
        String actual = driver.findElement(homePage).getText();
        Assert.assertEquals(actual, expected, "Home page verification failed!");
    }

    public void clickSignupLogin() {
        driver.findElement(signLogin).click();
    }
}