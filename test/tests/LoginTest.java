// --------------------------------------------------------------
// <copyright file="LoginTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All test methods from login page are here
// </summary>
// ---------------------------------------------------------------

package tests;

import com.relevantcodes.extentreports.LogStatus;
import data.LoginData;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.NavigationPage;
import resources.Messages;
import resources.PageNames;
import utilities.Report;

/**
 * @author Andres Lopez Molina
 */
public class LoginTest extends BaseTest {
    NavigationPage navigationPage;
    LoginPage loginPage;
    
    public void runLoginTestsPreconditions(){
        navigationPage = new NavigationPage(seleniumFramework);
        assertTrue(navigationPage.verifyLoads(),Messages.MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL);
        logger.log(LogStatus.INFO, "Navigation menu was loaded successfully");
        
        loginPage = navigationPage.goToLoginPage();
        assertTrue(loginPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
        logger.log(LogStatus.INFO, "Main elements of login page were loaded successfully");
    }
    
    @Test
    public void testVerifyThatLoginPageIsDisplayedWhenUserClickLoginLink(){
        logger = Report.getInstance().getReport().startTest("Verify That Login Page Is Displayed When User Click Login Link");
        
        logger.assignCategory("Login");
        
        runLoginTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        assertTrue(loginPage.verifyTabTitle(PageNames.LOGIN_PAGE));
        logger.log(LogStatus.PASS, "Login page was loaded with exit");
    }

    @Test (dataProvider = "incorrectUserNamesAndPasswords", dataProviderClass = LoginData.class)
    public void testVerifyThatUserIsNotAbleToLoginWithInvalidCredentials(String username, String password){
        logger = Report.getInstance().getReport().startTest("Verify That User Is Not Able To Login With Invalid Credentials");
        logger.assignCategory("Login");
        
        runLoginTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        //loginPage.login("alopezm", "Andres$321");
        loginPage.login(username,password);
        logger.log(LogStatus.INFO, "Attempt to login");
        
        assertTrue(loginPage.verifyErrorMessage(Messages.LOGIN_WAS_NOT_SUCCESSFUL));
        logger.log(LogStatus.PASS, "Login Was Verified");
    }

    @Test
    public void testVerifyThatUserIsAbleToLoginWithValidCredentials(){
        logger = Report.getInstance().getReport().startTest("Verify That User Is Able To Login With Valid Credentials");
        logger.assignCategory("Login");
        
        runLoginTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        loginPage.login("alopez", "AndresLM#123");
        logger.log(LogStatus.INFO, "Attempt to login");
        
        String expectedUsername = "alopezmmm";
        assertTrue(navigationPage.verifyUsernameText(expectedUsername));
        
        navigationPage.logout();
        logger.log(LogStatus.INFO, "Attempt to logout");
        
        logger.log(LogStatus.PASS, "Login verified");
    }
    
    @Test
    public void testVerifyThatLoginPageTitleIsCorrectWhenUserClickLoginButtonSeveralTimes(){
        SoftAssert softAssert = new SoftAssert();
        logger = Report.getInstance().getReport().startTest("Verify That Login Page Title Is Correct When User Click Login Link Several Times");
        logger.assignCategory("Login");
        
        runLoginTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        loginPage.clickOnLoginButton();
        logger.log(LogStatus.INFO, "Click Submit button 0");
        softAssert.assertTrue(loginPage.verifyTabTitle("login 0"));
        logger.log(LogStatus.PASS, "Passed assert 0");
        
        loginPage.clickOnLoginButton();
        logger.log(LogStatus.INFO, "Click Submit button 1");
        softAssert.assertTrue(loginPage.verifyTabTitle("login 1"));
        logger.log(LogStatus.FAIL, "Failed assert 1");
        
        loginPage.clickOnLoginButton();
        logger.log(LogStatus.INFO, "Click Submit button 2");
        softAssert.assertTrue(loginPage.verifyTabTitle("login 2"));
        logger.log(LogStatus.FAIL, "Failed assert 2");
        
        loginPage.clickOnLoginButton();
        logger.log(LogStatus.INFO, "Click Submit button 3");
        softAssert.assertTrue(loginPage.verifyTabTitle("login 3"));
        logger.log(LogStatus.FAIL, "Failed assert 3");
        
        softAssert.assertAll();
        logger.log(LogStatus.PASS, "Login verified with soft asserts");
    }
}
