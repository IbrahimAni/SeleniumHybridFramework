package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BrowserFactory {
    static WebDriverWait wait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeClass
    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }	else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }	else if(browserName.equalsIgnoreCase("IE")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }	else{
            System.out.println("We do not support this browser");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    @AfterClass
    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }
}
