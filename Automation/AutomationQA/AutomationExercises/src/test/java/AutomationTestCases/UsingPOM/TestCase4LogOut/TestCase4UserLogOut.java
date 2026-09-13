package AutomationTestCases.UsingPOM.TestCase4LogOut;

import AutomationTestCases.UsingPOM.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4UserLogOut extends BaseClass {

    @Test(groups = {"smoke"})
    public void LogOutTest() {
        TestCase4Page page = new TestCase4Page(driver);

        page.clickLoginLink();

        Assert.assertEquals(page.getLoginText(), "Login to your account");

        page.login("preksha34@gmail.com", "preksha34");

        Assert.assertEquals(page.getLoggedText(), "Logged in as Preksha Neupane");

        page.logout();

        Assert.assertEquals(page.getLoginText(), "Login to your account");
    }
}
