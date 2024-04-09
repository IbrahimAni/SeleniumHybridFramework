package com.automation.testcases;

import com.automation.pages.BasePage;
import com.automation.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass extends BasePage {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, "chrome", "https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }
}
