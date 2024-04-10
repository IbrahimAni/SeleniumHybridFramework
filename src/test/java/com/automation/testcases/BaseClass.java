package com.automation.testcases;

import com.automation.pages.BasePage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.Logs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class BaseClass extends BasePage {
    public WebDriver driver;
    String filePath = System.getProperty("user.dir")+ File.separator + "src/test/java/com/automation/testdata/automationdata.xlsx";

    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, "chrome", "https://demo.nopcommerce.com/");
        Logs.logInfo("Browser started.");
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }
}
