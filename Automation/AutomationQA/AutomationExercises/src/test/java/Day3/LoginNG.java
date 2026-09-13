package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNG {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.get("https://www.automationexercise.com");
    }

    @Test(priority=1)
    public void validLoginTest(){

        try {
            driver.findElement(By.cssSelector("a[href='/login']")).click();

            driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("preksha34@gmail.com");
            driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("preksha34");

            driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

            WebElement loggedInText = driver.findElement(By.cssSelector("li:nth-child(10) a:nth-child(1)"));
            String loggedText = loggedInText.getText();

            if (loggedText.equals("Logged in as Preksha Neupane")) {
                System.out.println("Login Success: Logged in as Preksha Neupane");
            }
        } finally {
            driver.quit();
        }
    }

    @Test(priority=2)
    public void invalidLoginTest(){
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("preksha34@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("prekshaa");

        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        WebElement loggedInText = driver.findElement(By.cssSelector("li:nth-child(10) a:nth-child(1)"));
        String loggedText = loggedInText.getText();
    }
}
