package com.resolver.pages;

import com.resolver.ActionHelper;
import org.openqa.selenium.By;
import org.testng.Assert;


public class Assessment_Page extends ActionHelper {

    public static String EMAIL = "wen.deng@test.com";
    public static String PASSWORD = "wen.deng@password";

    //Locators
    public static By Header_Test1 = By.xpath("//h1[text()='Test 1']");
    public static By Input_Email = By.id("inputEmail");
    public static By Input_Password = By.id("inputPassword");
    public static By Button_SignIn = By.xpath("//button[text()='Sign in']");

    public static By Header_Test2 = By.xpath("//h1[text()='Test 2']");
    public static By List_Item = By.cssSelector("#test-2-div .list-group-item");
    public static By List_Badge = By.xpath("//ul[@class='list-group']/li/span");

    public static By Header_Test3 = By.xpath("//h1[text()='Test 3']");
    public static By Dropdown_Button = By.id("dropdownMenuButton");
    public static By Dropdown_Option = By.className("dropdown-item");

    public static By Header_Test4 = By.xpath("//h1[text()='Test 4']");
    public static By Button1 = By.xpath("//h1[text()='Test 4']//following-sibling::button[1]");
    public static By Button2 = By.xpath("//h1[text()='Test 4']//following-sibling::button[2]");

    public static By Header_Test5 = By.xpath("//h1[text()='Test 5']");
    public static By Button5 = By.id("test5-button");
    public static By Alert_Test5 = By.id("test5-alert");

    public static By Header_Test6 = By.xpath("//h1[text()='Test 6']");
    private By Table = By.xpath("//div[@id='test-6-div']//table//tbody");

    public void userMoveMouseTo(By locator) {
        moveToElement(locator);
    }

    public void userMoveToBottomOfPage(){
        scrollToBottom();
    }

    public void validateInputExist(By locator) {
        Assert.assertTrue(isElementDisplayed(locator));
        logger.info("Verify the input exists");
    }

    public void validateButtonExist(By locator) {
        Assert.assertTrue(isElementDisplayed(locator));
        logger.info("Verify the button exists");
    }

    public void enterEmail(String email) {
        userSendKeyOnElement(Input_Email, email);
        logger.info("User entered email");
    }

    public void enterPassword(String password) {
        userSendKeyOnElement(Input_Password, password);
        logger.info("User entered password");
    }

    public int getListGroupItemsCount(By locator){
        return getNumberOfElements(locator);
    }

    public void validateNumberOfListGroupItems(int expect){
        Assert.assertEquals(getListGroupItemsCount(List_Item), expect);
        logger.info("Verify the number of list group items is " +expect+ " as expect");

    }

    public String getNthListItemValue(By listItem, By badge, int nthItem){
        String fullText = getTextFromElement(findMultipleElements(listItem).get(nthItem-1));
        String spanText = getNthListItemBadge(badge, nthItem);
        return fullText.replace(spanText, "").trim();
    }

    public void validateNthListItemValue(int nthItem, String expect){
        Assert.assertEquals(getNthListItemValue(List_Item, List_Badge, nthItem), expect);
        logger.info("Verify the " + nthItem + " list item value is: " + expect);
    }

    public String getNthListItemBadge(By badge, int nthItem){
        return getTextFromElement(findMultipleElements(badge).get(nthItem-1));
    }

    public void validateNthListItemBadge(int nthItem, String expect){
        Assert.assertEquals(getNthListItemBadge(List_Badge, nthItem), expect);
        logger.info("Verify the " + nthItem + " list item badge is: " + expect);
    }

    public String getOptionText(){
        return getTextFromElement(Dropdown_Button);
    }

    public void selectOption(String option){
        click(Dropdown_Button);
        selectDropdownOption(Dropdown_Option, option);
        logger.info("Select " + option + " from the dropdown");
    }

    public void validateOptionText(String expect){
        Assert.assertEquals(getOptionText(), expect);
        logger.info("Verify the option text is " + expect);
    }

    public void validateButtonEnabled(By locator){
        Assert.assertTrue(isElementEnabled(locator));
        logger.info("Verify the button is enabled");
    }

    public void validateButtonDisabled(By locator){
        Assert.assertFalse(isElementEnabled(locator));
        logger.info("Verify the button is disabled");
    }

    public void waitAndClickButton5(){
        waitUntilElementIsVisible(Button5, ELEMENT_WAIT_SECONDS);
        click(Button5);
        logger.info("Wait button is available and user clicks the button");
    }

    public void validateAlertDisplayed() {
        Assert.assertTrue(isElementDisplayed(Alert_Test5));
        logger.info("Verify the alert is displayed");
    }

    public String getCellValue(int row, int col){
        return getTableCellValue(Table, row, col);
    }

    public void validateCellValue(int row, int col, String expect) {
        Assert.assertEquals(getCellValue(row, col), expect);
        logger.info("Verify the cell value at coordinates (" +row+ "," +col+") is " + expect);
    }


}
