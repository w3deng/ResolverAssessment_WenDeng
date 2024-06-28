package com.resolver;

import com.resolver.test_base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActionHelper extends BaseTest {

    public static void browserNavigateToUrl(String url) {
        WebDriverHelp.goToUrl(url);
        waitForPageLoaded();
    }

    public static void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageLoaded() {
        try {
            new WebDriverWait(WebDriverHelp.getWebDriver(), Duration.ofSeconds(PAGE_WAIT_SECONDS)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                            .equals("complete"));
        } catch (Exception e) {
        }
    }

    public static WebElement waitUntilElementIsVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(WebDriverHelp.getWebDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean checkIfElementExist(By locator){
        return WebDriverHelp.getWebDriver().findElements(locator).size() > 0;
    }

    public static boolean isElementDisplayed(By locator){
        if(checkIfElementExist(locator)){
            return WebDriverHelp.getWebDriver().findElement(locator).isDisplayed();
        }else{
            return false;
        }
    }
    public static boolean isElementEnabled(By locator){
        if(checkIfElementExist(locator)){
            return WebDriverHelp.getWebDriver().findElement(locator).isEnabled();
        }else{
            return false;
        }
    }

    public static void userSendKeyOnElement(By locator, String text) {
        WebDriverHelp.getWebDriver().findElement(locator).sendKeys(text);
    }

    public static void moveToElement(By locator) {
        Actions action = new Actions(WebDriverHelp.getWebDriver());
        action.moveToElement(WebDriverHelp.getWebDriver().findElement(locator)).perform();
    }

    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverHelp.getWebDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static int getNumberOfElements(By locator) {
        return WebDriverHelp.getWebDriver().findElements(locator).size();
    }

    public static List<WebElement> findMultipleElements(By locator) {
        if (checkIfElementExist(locator)) {
            return WebDriverHelp.getWebDriver().findElements(locator);
        } else{
            logger.info("Element does NOT exist");
            return null;
        }
    }

    public static String getTextFromElement(By locator) {
        return WebDriverHelp.getWebDriver().findElement(locator).getText();
    }

    public static String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public static void click(By locator) {
        WebDriverHelp.getWebDriver().findElement(locator).click();
    }

    public static void selectDropdownOption(By locator, String optionText) {
        for (WebElement option : WebDriverHelp.getWebDriver().findElements(locator)) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public static String getTableCellValue(By locator, int row, int col) {
        return WebDriverHelp.getWebDriver().findElement(locator)
                .findElements(By.tagName("tr")).get(row)
                .findElements(By.tagName("td")).get(col).getText();
    }

}
