package com.automation.testcases;

import com.automation.pages.Homepage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{
    @BeforeClass
    public void initialize() {
        homepage = new Homepage(driver);
    }

    @Test
    public void verifyHomepageLogoDisplayed() {
        homepage.verifyLogoIsDisplayed();
    }

    @Test
    public void verifySearchFunctionality() {
        homepage.enterSearchText("Apple MacBook Pro 13-inch");
        homepage.clickSearchBtn();
    }

//    @Test
//    public void verifySearchResults() {
//        homepage.enterSearchText("Apple MacBook Pro 13-inch");
//        homepage.clickSearchBtn();
//    }
//
//    @Test
//    public void verifyRegisterLink() {
//        homepage.clickRegisterBtn();
//    }
}
