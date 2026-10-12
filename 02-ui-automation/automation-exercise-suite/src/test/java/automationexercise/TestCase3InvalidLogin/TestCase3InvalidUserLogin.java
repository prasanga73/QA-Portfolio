package automationexercise.TestCase3InvalidLogin;

import automationexercise.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3InvalidUserLogin extends BaseClass {

    @Test(groups = {"regression","smoke"})
    public void InvalidLoginTest() {
        TestCase3Page page = new TestCase3Page(driver);

        page.clickLoginLink();

        Assert.assertEquals(page.getLoginText(), "Login to your account");

        page.login("preksha@gmail.com", "preksha");

        Assert.assertEquals(page.getLoginErrorText(),"Your email or password is incorrect!");
    }
}
