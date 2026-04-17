package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails() {
        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(zip).sendKeys("12345");
    }

    public void completeOrder() {
        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();
    }
}