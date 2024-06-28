package com.resolver.ui_tests;

import com.resolver.pages.Assessment_Page;
import com.resolver.test_base.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static com.resolver.ActionHelper.*;

public class Assessment_Test extends BaseTest {

    Assessment_Page assessmentPage = new Assessment_Page();

    @BeforeMethod
    public void setUp(){
        logger.info("---------------------------------------------------------------");
        logger.info("Starting for the test");
        File file = new File("QE-index.html");
        String filePath = "file:///" + file.getAbsolutePath().replace("\\", "/");
        //each test case has mentioned "Navigate to home page" so make it as a step in beforemethod
        browserNavigateToUrl(filePath);
        logger.info("Navigate to the Assessment test page");
    }

    @Test
    public void test1(){
        assessmentPage.userMoveMouseTo(Assessment_Page.Header_Test2);
        assessmentPage.validateInputExist(Assessment_Page.Input_Email);
        assessmentPage.validateInputExist(Assessment_Page.Input_Password);
        assessmentPage.validateButtonExist(Assessment_Page.Button_SignIn);
        assessmentPage.enterEmail(Assessment_Page.EMAIL);
        assessmentPage.enterPassword(Assessment_Page.PASSWORD);
    }

    @Test
    public void test2(){
        assessmentPage.userMoveMouseTo(Assessment_Page.Header_Test3);
        assessmentPage.validateNumberOfListGroupItems(3);
        assessmentPage.validateNthListItemValue(2, "List Item 2");
        assessmentPage.validateNthListItemBadge(2, "6");
    }

    @Test
    public void test3(){
        assessmentPage.userMoveMouseTo(Assessment_Page.Header_Test4);
        assessmentPage.validateOptionText("Option 1");
        assessmentPage.selectOption("Option 3");
        assessmentPage.validateOptionText("Option 3");
    }

    @Test
    public void test4(){
        assessmentPage.userMoveMouseTo(Assessment_Page.Header_Test5);
        assessmentPage.validateButtonEnabled(Assessment_Page.Button1);
        assessmentPage.validateButtonDisabled(Assessment_Page.Button2);
    }

    @Test
    public void test5(){
        assessmentPage.userMoveMouseTo(Assessment_Page.Header_Test6);
        assessmentPage.waitAndClickButton5();
        assessmentPage.validateAlertDisplayed();
        assessmentPage.validateButtonDisabled(Assessment_Page.Button5);
    }

    @Test
    public void test6(){
        assessmentPage.userMoveToBottomOfPage();
        assessmentPage.validateCellValue(2,2, "Ventosanzap");
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        String testClassName = result.getTestClass().getName();
        String testMethodName = result.getMethod().getMethodName();
        logger.info("Test " + testClassName + "." + testMethodName + " is completed");
    }

}

