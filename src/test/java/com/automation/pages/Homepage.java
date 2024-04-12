package com.automation.pages;

import com.automation.utilities.logutils.Logs;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage{
    WebDriver driver;
    Logger logger = Logger.getLogger(Homepage.class);

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locate elements
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']") WebElement nopCommerceLogo;
    @FindBy(xpath = "//input[@id='small-searchterms']") WebElement searchInputField;
    @FindBy(xpath = "//*[@id='small-search-box-form']/button") WebElement searchBtn;
    @FindBy(xpath = "//a[@class='ico-register']") WebElement registerBtn;

    //Methods
    public void enterSearchText(String text) {
        searchInputField.sendKeys(text);
    }

    public void clickSearchBtn() {
        searchBtn.click();
        logger.info("Search button clicked.");
    }

    public void clickRegisterBtn() {
        registerBtn.click();
        logger.info("Register button clicked.");
        logger.error("Register button unclickable.");
    }

    public void verifyLogoIsDisplayed() {
        nopCommerceLogo.isDisplayed();
    }

}
