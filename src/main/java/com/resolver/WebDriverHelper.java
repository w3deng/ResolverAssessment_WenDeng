package com.resolver;

import com.resolver.test_base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper extends BaseTest {
    //create ThreadLocal to ensure thread safety, actually don't need for this assessment
    //we can just use driver, but it's good practice for the real project
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void setupWebDriver() {
        driver.set(new ChromeDriver());
    }

    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static void goToUrl(String url) {
        if (getWebDriver() == null) {
            setupWebDriver();
        }
        getWebDriver().navigate().to(url);
        getWebDriver().manage().window().maximize();
    }

    public static void removeWebDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
            driver.remove();
        }
    }


}
