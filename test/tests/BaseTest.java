// --------------------------------------------------------------
// <copyright file="BaseTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Base Class With General Methods and attributes to use in 
//     every test class, like drivers creation and some settings
// </summary>
// ---------------------------------------------------------------

package tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.net.MalformedURLException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import resources.Tags;
import utilities.DriverFactory;
import utilities.IDriver;
import utilities.Report;
import utilities.SeleniumFramework;
import utilities.SeleniumScreenshot;

/**
 * @author Andres Lopez Molina
 */
public class BaseTest {
    
    protected SeleniumFramework seleniumFramework;
    protected Report report;
    protected ExtentTest logger;
    String filePath = "C:\\Selenium\\reports\\AutomationTraining["+1+"].html";
    
    @BeforeTest
    @Parameters(value={"appUrl"})
    public void printStartingExecution(String appUrl) throws MalformedURLException {
        System.out.println("Starting Testing Execution");
        Tags.appUrl=appUrl;   
    }
    
    @BeforeTest (dependsOnMethods={"printStartingExecution"})
    public void saveReport(ITestContext test){
        //report = new Report("C:\\Selenium\\reports\\AutomationTraining["+test.getName()+"].html");
        report = new Report("Luis Second Test");

    }
    
    @BeforeClass(alwaysRun = true)
    public void setUpTestClass() throws Exception {
        System.out.println(String.format("Executing Class: %s",this.getClass().getName()));
        //report = new Report("C:\\Selenium\\reports\\AutomationTraining["+this.getClass().getName()+"].html");
        //report = new Report("Luis Test");
    }
    
    @BeforeMethod
    @Parameters(value={"mode","browser","platform"})
    public void setupTestCase (String mode, String browser, String platform) throws MalformedURLException {
        IDriver driver= DriverFactory.createDriver(mode);
        driver.buildDriver(browser, platform);
        
        seleniumFramework = new SeleniumFramework(driver.getDriverInstance());
        seleniumFramework.goToPage("default.aspx");
    }
    
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                String screeshotPath = SeleniumScreenshot.takeScreenshot(seleniumFramework.getDriver(), "Error - " + result.getName());
                String image = logger.addScreenCapture(screeshotPath);
                logger.log(LogStatus.FAIL, result.getThrowable().toString(),image);
                break;
            case ITestResult.SKIP:
                logger.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
                break;
            default:
                logger.log(LogStatus.PASS, "Test passed");
                break;
        }
        
        Report.getInstance().getReport().endTest(logger);
        
        System.out.println("Deleting Driver");
        seleniumFramework.closeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println(String.format("Completing execution class: %s",this.getClass().getName()));
        /*Report.getInstance().getReport().flush();
        Report.getInstance().getReport().close();*/
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("Completing Test Execution");
        Report.getInstance().getReport().flush();
        Report.getInstance().getReport().close();
    }
 
  
}
