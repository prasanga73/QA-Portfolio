package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;

public class ChromeAutomation {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/login");

            WebElement emailField = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
            emailField.sendKeys("preksha34@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("preksha34");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
            submitButton.click();

        } finally {
            driver.quit();
        }
    }

}