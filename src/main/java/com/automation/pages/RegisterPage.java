package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locate elements
    @FindBy(xpath = "//input[@id='FirstName']") WebElement firstName;
    @FindBy(xpath = "//input[@id='LastName']") WebElement lastName;
    @FindBy(xpath = "//input[@id='Email']") WebElement email;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']") WebElement dayDropdown;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']") WebElement monthDropdown;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']") WebElement yearDropdown;
    @FindBy(xpath = "//input[@id='Company']") WebElement company;
    @FindBy(xpath = "//input[@id='Newsletter']") WebElement newsletter;
    @FindBy(xpath = "//input[@id='Password']") WebElement password;
    @FindBy(xpath = "//input[@id='ConfirmPassword']") WebElement confirmPassword;
    @FindBy(xpath = "//span[@id='FirstName-error']") WebElement firstnameErr;
    @FindBy(xpath = "//span[@id='LastName-error']") WebElement lastnameErr;
    @FindBy(xpath = "//span[@id='Password-error']") WebElement passwordErr;
    @FindBy(xpath = "//span[@id='Email-error']") WebElement emailErr;
    @FindBy(xpath = "//li[normalize-space()='The specified email already exists']") WebElement existingEmailErr;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']") WebElement confirmPasswordErr;
    @FindBy(xpath = "//button[@id='register-button']") WebElement registerBtn;
    @FindBy(xpath = "//div[@class='result']") WebElement registrationCompletedMsgWebElement;

    //Methods
    public void enterFirstName(String text){
        firstName.sendKeys(text);
    }

    public void enterLastName(String text){
        lastName.sendKeys(text);
    }

    public void enterEmail(String text){
        email.sendKeys(text);
    }

    public void enterCompany(String text){
        company.sendKeys(text);
    }

    public void enterPassword(String text){
        password.sendKeys(text);
    }

    public void enterConfirmPassword(String text){
        confirmPassword.sendKeys(text);
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

    public void verifyRegistrationSuccessMsg() {
        registrationCompletedMsgWebElement.isDisplayed();
    }

    public void verifyFirstNameErr() {
        firstnameErr.isDisplayed();
    }

    public void verifyLastNameErr() {
        lastnameErr.isDisplayed();
    }

    public void verifyPasswordErr() {
        passwordErr.isDisplayed();
    }

    public void verifyEmailErr() {
        emailErr.isDisplayed();
    }

    public void verifyExistingEmailErr() {
        existingEmailErr.isDisplayed();
    }

    public void verifyConfirmPasswordErr() {
        confirmPasswordErr.isDisplayed();
    }

    public void selectDateOfBirth(String day, String month, String year) {
        dayDropdown.sendKeys(day);
        monthDropdown.sendKeys(month);
        yearDropdown.sendKeys(year);
    }

    public void enableNewsletter(boolean shouldEnableNewsletter) {
        boolean isChecked = newsletter.isSelected();
        if (shouldEnableNewsletter && !isChecked) {
            newsletter.click();
        }else if(!shouldEnableNewsletter && isChecked) {
            newsletter.click();
        }
    }

    public String getRegistrationSuccessMsg() {
        return registrationCompletedMsgWebElement.getText();
    }

    public String getPasswordErrorTxt(){
        return passwordErr.getText();
    }

    public String getConfirmPasswordErrorTxt() {
        return confirmPasswordErr.getText();
    }

    public String getEmailErrorTxt() {
        return emailErr.getText();
    }

    public String getFirstNameErrorTxt() {
        return firstnameErr.getText();
    }

    public String getLastNameErrorTxt() {
        return lastnameErr.getText();
    }

    public String getExistingEmailErrorTxt() {
        return existingEmailErr.getText();
    }
}
