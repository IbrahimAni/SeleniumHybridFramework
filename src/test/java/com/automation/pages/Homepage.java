package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    WebDriver driver;

    public Homepage(WebDriver rDriver) {
        this.driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    //Locate elements
    @FindBy(xpath = "//img[@element-id='358']") WebElement logo;
    @FindBy(xpath = "//input[@id='small-searchterms']") WebElement searchInput;
    @FindBy(xpath = "//*[@id='small-search-box-form']/button") WebElement searchButton;
}
