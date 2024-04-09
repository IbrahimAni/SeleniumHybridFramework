package com.automation.testcases;

import com.automation.pages.Homepage;
import com.automation.pages.RegisterPage;
import org.testng.annotations.BeforeClass;

public class RegisterPageTest extends BaseClass {
    @BeforeClass
    public void initialize() {
        homepage = new Homepage(driver);
        registerPage = new RegisterPage(driver);
    }

    private void fillRegisterForm() {
        homepage.clickRegisterBtn();
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Doe");
        registerPage.enterEmail("john@doe.com");
        registerPage.enterPassword("password123");
        registerPage.enterConfirmPassword("password123");
        registerPage.clickRegisterBtn();
    }
}
