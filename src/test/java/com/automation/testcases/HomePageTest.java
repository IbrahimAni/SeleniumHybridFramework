package com.automation.testcases;

import com.automation.pages.Homepage;
import com.automation.utilities.ExcelScript;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseClass{
    private Homepage homepage;

    @BeforeClass
    public void initialize() {
        homepage = new Homepage(driver);
    }

    @Test
    public void verifyHomepageLogoDisplayed() throws IOException {
        homepage.verifyLogoIsDisplayed();
        takeScreenShot("verifyHomepageLogoDisplayed");
    }

    @Test(dataProvider = "searchData", description = "User can search for items on the homepage.")
    public void verifySearchFunctionality(String searchText) throws IOException {
        homepage.enterSearchText(searchText);
        homepage.clickSearchBtn();

        takeScreenShot("verifySearchFunctionality");
    }

    @DataProvider(name = "searchData")
    private String[][] searchInputData() throws IOException {
        int rowCount = ExcelScript.getRowCount(filePath, "search_data");
        int cellCount = ExcelScript.getCellCount(filePath, "search_data", rowCount);

        String[][] searchItems = new String[rowCount][cellCount];

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                searchItems[i-1][j] = ExcelScript.getCellData(filePath, "search_data", i, j);
            }
        }

        return searchItems;
    }
}
