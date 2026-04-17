package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    By productTitle = By.className("inventory_item_name");
    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void addProductToCart() {
        driver.findElement(addToCart).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}