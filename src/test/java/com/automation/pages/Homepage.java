package com.automation.pages;

import com.automation.utilities.logutils.Logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    WebDriver driver;

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
        Logs.logInfo("Search button clicked.");
    }

    public void clickRegisterBtn() {
        registerBtn.click();
        Logs.logInfo("Register button clicked.");
        Logs.logError("Register button unclickable.");
    }

    public void verifyLogoIsDisplayed() {
        nopCommerceLogo.isDisplayed();
    }

}
