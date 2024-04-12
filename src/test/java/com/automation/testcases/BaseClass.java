package com.automation.testcases;

import com.automation.utilities.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public WebDriver driver;
    Logger logger = Logger.getLogger(BaseClass.class);
    String filePath = System.getProperty("user.dir")+ File.separator + "src/test/java/com/automation/testdata/automationdata.xlsx";

    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, "chrome", "https://demo.nopcommerce.com/");
        logger.info("Browser started.");
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    /** Method to capture screenshots */
    public void takeScreenShot(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+screenshotName+".png");
        FileUtils.copyFile(source, target);
//        System.out.println("Screenshot taken");
    }
}
