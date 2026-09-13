package AutomationTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase1RegisterUser {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com");

            WebElement loginBtn = driver.findElement(By.cssSelector("a[href='/login']"));
            loginBtn.click();

            WebElement signupText =  driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
            String actualText = signupText.getText();

            if (actualText.equals("New User Signup!")) {
                System.out.println("Text matches: New User Signup!");
            } else{
                System.out.println("Text does not match");
            }

            WebElement name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
            name.sendKeys("Prasanga Niraula");

            driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("prasanganiraula2016@gmail.com");

            WebElement signupBtn = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
            signupBtn.click();

            WebElement accountInfoText = driver.findElement(By.cssSelector("body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > b:nth-child(1)"));
            String actualText2 = accountInfoText.getText();

            if (actualText2.equals("ENTER ACCOUNT INFORMATION")) {
                System.out.println("Text matches: ENTER ACCOUNT INFORMATION");
            }

            driver.findElement(By.id("id_gender1")).click(); // Mr.
            driver.findElement(By.id("password")).sendKeys("Password@123");
            new Select(driver.findElement(By.id("days"))).selectByValue("17");
            new Select(driver.findElement(By.id("months"))).selectByValue("12");
            new Select(driver.findElement(By.id("years"))).selectByValue("2002");

            driver.findElement(By.id("newsletter")).click();

            driver.findElement(By.id("optin")).click();


            driver.findElement(By.id("first_name")).sendKeys("Test");
            driver.findElement(By.id("last_name")).sendKeys("User");
            driver.findElement(By.id("company")).sendKeys("Tech Axis");
            driver.findElement(By.id("address1")).sendKeys("Lalitpur");
            driver.findElement(By.id("address2")).sendKeys("Kumaripati");
            new Select(driver.findElement(By.id("country"))).selectByVisibleText("Australia");
            driver.findElement(By.id("state")).sendKeys("Koshi");
            driver.findElement(By.id("city")).sendKeys("Canberra");
            driver.findElement(By.id("zipcode")).sendKeys("56705");
            driver.findElement(By.id("mobile_number")).sendKeys("9812345678");


            driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

            WebElement accountCreated = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[data-qa='account-created']"))
            );
            String accountCreatedText = accountCreated.getText();
            if (accountCreatedText.equals("ACCOUNT CREATED!")) {
                System.out.println("Text matches: ACCOUNT CREATED!");
            } else {
                System.out.println("Text does not match. Found: " + accountCreatedText);
            }

            driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

            WebElement loggedInAs = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]"))
            );
            String loggedInText = loggedInAs.getText();
            if (loggedInText.contains("Logged in as")) {
                System.out.println("Text matches: " + loggedInText);
            } else {
                System.out.println("Text does not match. Found: " + loggedInText);
            }

            driver.findElement(By.linkText("Delete Account")).click();

            WebElement accountDeleted = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[data-qa='account-deleted']"))
            );
            String accountDeletedText = accountDeleted.getText();
            if (accountDeletedText.equals("ACCOUNT DELETED!")) {
                System.out.println("Text matches: ACCOUNT DELETED!");
            } else {
                System.out.println("Text does not match. Found: " + accountDeletedText);
            }

            driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

            System.out.println("Test Case 1: Register User - COMPLETED");

        } finally {
            driver.quit();
        }

    }
}
