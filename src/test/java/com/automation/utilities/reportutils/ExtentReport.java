package com.automation.utilities.reportutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class ExtentReport extends TestListenerAdapter {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    private final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext testContext) {
        String reportPath = System.getProperty("user.dir") + "/test-output/extent-report.html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        try{
            sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/test/java/com/automation/utilities/reportutils/extent-config.xml");
        }catch (IOException e){
            throw new RuntimeException("Unable to load the XML config file to configure Extent Report.");
        }

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "Development");
        extent.setSystemInfo("User", "Customer");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Operating System", "Windows 10");
        extent.setSystemInfo("Test Framework", "Selenium Hybrid Framework");
        extent.setSystemInfo("Test Tool", "TestNG");
        extent.setSystemInfo("Tester", "Ibrahim");
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName()).assignCategory(result.getMethod().getGroups());

        if(result.getParameters() !=  null && result.getParameters().length > 0) {
            StringBuilder params = new StringBuilder();
            for (Object param : result.getParameters()) {
                params.append(param).append(" ");
            }
            extentTest.info("Test with parameters: " + params);
        }
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        ExtentTest extentTest = test.get().pass(MarkupHelper.createLabel(tr.getMethod().getMethodName(), ExtentColor.GREEN));

        // Add test description, if available
        if (tr.getMethod().getDescription() != null) {
            extentTest.info("Description: " + tr.getMethod().getDescription());
        }

        // Add categories
        String[] categories = tr.getMethod().getGroups();
        if (categories.length > 0) {
            extentTest.assignCategory(categories);
        }

        // Attach screenshot
        attachScreenshot(tr.getName(), Status.PASS);
    }

    @Override
    public void onTestFailure(ITestResult tr){
        ExtentTest extentTest = test.get().fail(MarkupHelper.createLabel(tr.getMethod().getMethodName(), ExtentColor.RED));

        // Add test description, if available
        if (tr.getMethod().getDescription() != null) {
            extentTest.info("Description: " + tr.getMethod().getDescription());
        }

        // Add categories
        String[] categories = tr.getMethod().getGroups();
        if (categories.length > 0) {
            extentTest.assignCategory(categories);
        }

        // Attach screenshot
        attachScreenshot(tr.getName(), Status.FAIL);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        ExtentTest extentTest = test.get().skip(MarkupHelper.createLabel(tr.getMethod().getMethodName(), ExtentColor.ORANGE));

        // Log the reason for skipping the test
        if (tr.getThrowable() != null) {
            extentTest.log(Status.SKIP, "Test skipped due to: " + tr.getThrowable().getMessage());
        } else {
            extentTest.log(Status.SKIP, "Test skipped");
        }

        // Add category annotation, if any
        String[] categories = tr.getMethod().getGroups();
        if (categories.length > 0) {
            extentTest.assignCategory(categories);
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }

    private void attachScreenshot(String testName, Status status) {
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
        File screenshot = new File(screenshotPath);

        if (screenshot.exists()) {
            try {
                test.get().log(status, "Screenshot attached",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                test.get().log(status, "An exception occurred while attaching a screenshot.");
            }
        } else {
            test.get().log(Status.WARNING, "Screenshot was not found at: " + screenshotPath);
        }
    }
}
