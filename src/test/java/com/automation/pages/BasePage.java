package com.automation.pages;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class BasePage {
    private static final String log4jFilePath = System.getProperty("user.dir")+ File.separator+ "src/test/java/com/automation/utilities/logutils/log4j.properties";

    public BasePage() {
        PropertyConfigurator.configure(log4jFilePath);
    }
//    protected Homepage homepage;
//    protected RegisterPage registerPage;
}
