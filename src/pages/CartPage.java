package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartItem = By.className("inventory_item_name");
    By checkoutBtn = By.id("checkout");
    By removeBtn = By.xpath("//button[text()='Remove']");

    public String getCartItem() {
        return driver.findElement(cartItem).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public void removeItem() {
        driver.findElement(removeBtn).click();
    }
}