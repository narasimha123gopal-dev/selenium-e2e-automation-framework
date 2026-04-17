package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By checkoutBtn = By.id("checkout");
    By removeBtn = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeProduct() {
        driver.findElement(removeBtn).click();
    }

    public void checkout() {
        driver.findElement(checkoutBtn).click();
    }
}