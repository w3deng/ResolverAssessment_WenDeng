package com.resolver.test_base;

import com.resolver.WebDriverHelper;
import com.resolver.utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriverHelper WebDriverHelp;
    protected static final Logger logger = LoggerUtil.getLogger();

    protected static int ELEMENT_WAIT_SECONDS = 30;
    protected static int PAGE_WAIT_SECONDS = 60;

    @BeforeClass
    public void setUpBrowser() {
        WebDriverHelp.setupWebDriver();
        logger.info("Set up the Web Driver");
    }

    @AfterClass
    public void cleanup() {
        WebDriverHelp.removeWebDriver();
        logger.info("Remove the Web Driver");
    }
}
