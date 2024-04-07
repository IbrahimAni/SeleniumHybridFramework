package com.automation.testcases;

import com.automation.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, "chrome", "https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }
}
