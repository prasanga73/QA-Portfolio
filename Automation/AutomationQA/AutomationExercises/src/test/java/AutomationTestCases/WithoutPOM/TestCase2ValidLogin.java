package AutomationTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase2ValidLogin {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com");

            WebElement loginBtn = driver.findElement(By.cssSelector("a[href='/login']"));
            loginBtn.click();

            WebElement loginText = driver.findElement(By.cssSelector("div[class='login-form'] h2"));
            String actualLoginText = loginText.getText();

            if (actualLoginText.equals("Login to your account")) {
                System.out.println("Text matches: Login to your account");
            }
            else{
                System.out.println("Text does not match, dimwit. Try again and do it properly.");
            }

            driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("preksha34@gmail.com");
            driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("preksha34");

            driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

            WebElement loggedText = driver.findElement(By.cssSelector("li:nth-child(10) a:nth-child(1)"));
            String actualLoggedText = loggedText.getText();
            if (actualLoggedText.equals("Logged in as Preksha Neupane")) {
                System.out.println("Text matches: Logged in as Preksha Neupane");
            } else{
                System.out.println("Text does not match, dimwit. Try again and do it properly.");
            }

            System.out.println("Test Case 2: Login User with correct email and password - COMPLETED");

        } finally {
            driver.quit();
        }

    }
}
