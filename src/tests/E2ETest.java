package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import pages.*;
import utils.DriverFactory;

import static org.testng.Assert.*;

public class E2ETest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void endToEndTest() {

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        // Step 1: Open site
        login.openSite();

        // Step 2: Login
        login.login("standard_user", "secret_sauce");

        // Step 3: Get product
        String productName = inventory.getProductTitle();
        System.out.println("Product: " + productName);

        // Validation 1
        assertNotNull(productName, "Product title missing");

        // Step 4: Add to cart
        inventory.addProductToCart();
        inventory.openCart();

        // Step 5: Validate cart
        String cartItem = cart.getCartItem();
        assertEquals(productName, cartItem, "Cart item mismatch");

        // Step 6: Checkout
        cart.clickCheckout();
        checkout.enterDetails();
        checkout.finishOrder();

        // Validation 2
        String success = checkout.getSuccessMessage();
        assertTrue(success.contains("THANK YOU"), "Order failed");

        // Step 7: Remove flow
        driver.get("https://www.saucedemo.com/inventory.html");
        inventory.addProductToCart();
        inventory.openCart();
        cart.removeItem();

        System.out.println("Test Completed Successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}