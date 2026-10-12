package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

    private By cartBtn = By.cssSelector(".shopping_cart_link");
    private By productItem = By.className("inventory_item");
    private By productHeroText = By.cssSelector(".title");
    private By addtoCartBtn = By.cssSelector("button[data-test^='add-to-cart']");
    private By backToProductText = By.cssSelector("#back-to-products");
    private By productNameText = By.cssSelector(".inventory_item_name");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isOnProductPage(){
        Assert.assertEquals(driver.findElement(productHeroText).getText(),"Products");
    }

    public List<WebElement> getProductsList(){
        return driver.findElements(productItem);
    }

    public List<String> addItemstoCart(){
        CartPage cartPage = new CartPage(driver);

        if (!getProductsList().isEmpty()){
            cartPage.removeCartItems();
        }

        List<WebElement> inventoryItems = driver.findElements(productItem);
        List<String> addedItemNames = new ArrayList<>();

        for (WebElement item: inventoryItems){
            String name = item.findElement(productNameText).getText();
            item.findElement(addtoCartBtn).click();
            addedItemNames.add(name);
        }
        return addedItemNames;
    }



    public String getProductHeroText(){
        return driver.findElement(productHeroText).getText();
    }

    public String getBacktoProductText(){
        return driver.findElement(backToProductText).getText();
    }

    public void navigateToCart(){
        driver.findElement(cartBtn).click();
    }






}
