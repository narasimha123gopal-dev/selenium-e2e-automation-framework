package tests;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverFactory;

public class LoginTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getDriver();

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        // 🔹 Test users
        String[][] users = {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"}
        };

        for (String[] user : users) {

            login.openSite();
            login.login(user[0], user[1]);

            // ✅ Validation 1: Handle invalid/locked user
            if (driver.getPageSource().contains("locked out")) {
                System.out.println("❌ Login failed for: " + user[0]);
                continue;
            }

            // ✅ Validation 2: Product title visible
            String title = inventory.getProductTitle();
            if (!title.isEmpty()) {
                System.out.println("✅ Product visible: " + title);
            }

            // Add to cart
            inventory.addProductToCart();
            inventory.goToCart();

            // Remove product (cancel scenario)
            cart.removeProduct();

            // Add again
            driver.navigate().back();
            inventory.addProductToCart();
            inventory.goToCart();

            // Checkout
            cart.checkout();
            checkout.enterDetails();
            checkout.completeOrder();

            // ✅ Validation 3: Order confirmation
            if (driver.getPageSource().contains("Thank you for your order")) {
                System.out.println("✅ Order completed for: " + user[0]);
            }

            driver.quit();
        }
    }
}