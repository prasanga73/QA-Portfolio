package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;

public class BraveWorkaround {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/home/ethereal/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/brave-browser");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("test-type"));

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