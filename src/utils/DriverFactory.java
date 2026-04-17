package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver getDriver() {

        ChromeOptions options = new ChromeOptions();

        // Disable password popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        // Stability
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        // ✅ Selenium Manager will handle driver automatically
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        return driver;
    }
}