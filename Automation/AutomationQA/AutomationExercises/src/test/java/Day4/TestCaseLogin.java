package Day4;

import Day4.baseClass;
import Day4.HomePage;
import Day4.LoginPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseLogin extends baseClass {

    @Test(priority = 1)
    public void loginTest() {
        HomePage home = new HomePage(driver);
        LoginPageObject login = new LoginPageObject(driver);

        home.verifyHomePage("Home");
        home.clickSignupLogin();

        Assert.assertEquals(login.verifyLoginHeading(), "Login to your account");

        login.enterEmail("preksha34@gmail.com");
        login.enterPassword("preksha34");
        login.clickLogin();

        Assert.assertEquals(login.verifyLoggedInUser(), "Preksha Neupane");

        login.clickLogout();

        Assert.assertEquals(login.verifyLoginHeading(), "Login to your account");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        HomePage home = new HomePage(driver);
        LoginPageObject login = new LoginPageObject(driver);

        home.verifyHomePage("Home");
        home.clickSignupLogin();

        Assert.assertEquals(login.verifyLoginHeading(), "Login to your account");

        login.enterEmail("preksha34@gmail.com");
        login.enterPassword("wrongpassword");
        login.clickLogin();

        Assert.assertEquals(login.verifyInvalidLogin(), "Your email or password is incorrect!");
    }

    @Test(priority = 3)
    public void empty() {
        // Placeholder for future test cases
    }
}