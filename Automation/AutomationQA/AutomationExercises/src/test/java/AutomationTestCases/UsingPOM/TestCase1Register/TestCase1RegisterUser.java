package AutomationTestCases.UsingPOM.TestCase1Register;

import AutomationTestCases.UsingPOM.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1RegisterUser extends BaseClass {

    @Test(groups = {"regression","smoke"})
    public void registerUserTest() {
        TestCase1Page page = new TestCase1Page(driver);

        page.clickLoginLink();

        Assert.assertEquals(page.getSignupText(), "New User Signup!");

        page.enterSignupDetails("Prasanga Niraula", "prasanganiraula2016@gmail.com");
        page.clickSignup();

        Assert.assertEquals(page.getAccountInfoText(), "ENTER ACCOUNT INFORMATION");

        page.fillAccountInformation("Password@123", "17", "12", "2002");
        page.fillAddressInformation("Test", "User", "Tech Axis", "Lalitpur", "Kumaripati", "Australia", "Koshi", "Canberra", "56705", "9812345678");
        page.clickCreateAccount();

        Assert.assertEquals(page.getAccountCreatedText(), "ACCOUNT CREATED!");

        page.clickContinue();

        Assert.assertTrue(page.getLoggedInAsText().contains("Logged in as"));

        page.clickDeleteAccount();

        Assert.assertEquals(page.getAccountDeletedText(), "ACCOUNT DELETED!");

        page.clickContinue();
    }
}
