package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("s","s");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        }	else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("", "");
            driver = new FirefoxDriver();
        }	else if(browserName.equalsIgnoreCase("IE")){
            System.setProperty("", "");
            driver = new InternetExplorerDriver();
        }	else{
            System.out.println("We do not support this browser");
        }

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
    }

    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }
}
