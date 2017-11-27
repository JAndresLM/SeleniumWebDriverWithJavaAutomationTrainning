// --------------------------------------------------------------
// <copyright file="RegisterTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All test methods from Register page are here
// </summary>
// ---------------------------------------------------------------

package tests;

import com.relevantcodes.extentreports.LogStatus;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.NavigationPage;
import pages.RegisterPage;
import pages.RegisterPageLabels;
import resources.Messages;
import resources.PageNames;
import utilities.Report;

/**
 * @author Andres Lopez Molina
 */
public class RegisterTest extends BaseTest{
    NavigationPage navigationPage;
    RegisterPage registerPage;
    RegisterPageLabels registerPageLabels;
    
    public void runRegisterTestsPreconditions(){
        navigationPage = new NavigationPage(seleniumFramework);
        assertTrue(navigationPage.verifyLoads(),Messages.MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL);
        logger.log(LogStatus.INFO, "Navigation menu was loaded successfully");
        
        registerPage = navigationPage.goToRegisterPage();
        assertTrue(registerPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
        logger.log(LogStatus.INFO, "Main elements of register page were loaded successfully");
        
        registerPageLabels = new RegisterPageLabels(seleniumFramework);
    }

    @Test
    public void verifyThatRegisterPageIsDisplayedWhenClickingOnRegisterLink() throws Exception {
        logger = Report.getInstance().getReport().startTest("Verify That Register Page Is Displayed When User Click Register Link");
        logger.assignCategory("Register");
        
        runRegisterTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        assertTrue(registerPage.verifyTabTitle(PageNames.REGISTER_PAGE));
        logger.log(LogStatus.PASS, "Register Was Verified");
    }
  
    @Test
    public void verifyThatAllMandatoryMessagesAreDisplayedWhenAllMandatoryFieldsAreEmptyAfterClickSubmitButton() throws Exception {
        logger = Report.getInstance().getReport().startTest("verify That All Mandatory Messages Are Displayed When All Mandatory Fields Are Empty After Click Submit Button");
        logger.assignCategory("Register");
        
        runRegisterTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        registerPage.clickOnSubmitButton();
        logger.log(LogStatus.INFO, "Click on submit button");
        
        assertTrue(registerPageLabels.verifyEveryRequiredFieldErrorMessage(Messages.TEXTFIELDS_REQUIRED_LIST));
        logger.log(LogStatus.PASS, "Register Was Verified");
    }
  
    @Test
    public void verifyThatErrorMessageIsDisplayedWhenCreatingUserWithUserNameThatIsAlreadyTaken() throws Exception {
        logger = Report.getInstance().getReport().startTest("verify That Error Message Is Displayed When Creating User With UserName That Is Already Taken");
        logger.assignCategory("Register");
        
        runRegisterTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        registerPage.createNewUser("Andres", "Molina", "andres.molina@gmail.com", "alopezm", "Molina$123", "Molina$123", "first 3 letters of alphabet?", "abc");
        logger.log(LogStatus.INFO, "Attempt to Register");
        
        assertTrue(registerPageLabels.verifyUserNameAlreadyExistsErrorMessage(Messages.USERNAME_ALREADY_EXISTS));
        logger.log(LogStatus.PASS, "Register Was Verified");
    }
  
    @Test
    public void verifyThatErrorMessageIsDisplayedWhenSendingDifferentPasswordsOnPasswordAndConfirmPasswordFields() throws Exception {
        logger = Report.getInstance().getReport().startTest("verify That Error Message Is Displayed When Sending Different Passwords On Password And Confirm Password Fields");
        logger.assignCategory("Register");
        
        runRegisterTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        registerPage.createNewUser("Daichi", "Sawamura", "dai.sawa@hotmail.com", "sawadai", "Sawa$456", "saWa$987", "last 3 letters of alphabet?", "xyz");
        logger.log(LogStatus.INFO, "Attempt to Register");
        
        assertTrue(registerPageLabels.verifyPasswordsMustMatchErrorMessage(Messages.PASSWORD_AND_CONFIRM_PASSWORD_MUST_MATCH));
        logger.log(LogStatus.PASS, "Register Was Verified");
    }
  
    @Test
    public void verifyThatErrorMessageIsDisplayedWhenSendingInvalidEmailOnEmailField() throws Exception {
        logger = Report.getInstance().getReport().startTest("verify That Error Message Is Displayed When Sending Invalid Email On Email Field");
        logger.assignCategory("Register");
        
        runRegisterTestsPreconditions();
        logger.log(LogStatus.INFO, "Preconditions OK");
        
        registerPage.createNewUser("Sakasagami", "Yura", "yura@sakasagami", "sakayu", "Yu$123456", "Yu$123456", "Big Animal On the Earth?", "Whale");
        logger.log(LogStatus.INFO, "Attempt to Register");
        
        assertTrue(registerPageLabels.verifyValidEmailRequiredErrorMessage(Messages.VALID_EMAIL_IS_REQUIRED));
        logger.log(LogStatus.PASS, "Register Was Verified");
    } 
}
