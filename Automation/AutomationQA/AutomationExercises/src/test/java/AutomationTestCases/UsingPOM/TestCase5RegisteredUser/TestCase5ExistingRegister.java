package AutomationTestCases.UsingPOM.TestCase5RegisteredUser;

import AutomationTestCases.UsingPOM.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5ExistingRegister extends BaseClass {

    @Test(groups = {"regression"})
    public void ExistingUserTest() {
        TestCase5Page page = new TestCase5Page(driver);

        page.clickLoginLink();

        Assert.assertEquals(page.getSignupText(), "New User Signup!");

        page.signup("preksha34@gmail.com","Preksha Neupane");

        Assert.assertEquals(page.getUserExistsText(), "Email Address already exist!");

    }
}
