// --------------------------------------------------------------
// <copyright file="LoginPage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Login Page
// </summary>
// ---------------------------------------------------------------

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumFramework;

/**
 * @author Andres Lopez Molina
 */
public class LoginPage extends BasePage{
    @FindBy(id="ctl00_Main_LoginConrol_UserName")
    WebElement userNameTextfield;
    
    @FindBy(id="ctl00_Main_LoginConrol_Password")
    WebElement passwordTextfield;
    
    @FindBy(id="ctl00_Main_LoginConrol_LoginButton")
    WebElement loginButton;
    
    @FindBy(id="ctl00_Main_LoginConrol_RememberMe")
    WebElement rememberNextTimecheckBox;
    
    @FindBy(id="ctl00_Main_RegisterLink")
    WebElement createAccountLink;
    
    @FindBy(id="ctl00_Main_ForgotPasswordButton")
    WebElement forgotPasswordLink;
    
    @FindBy(xpath="//table[@id='ctl00_Main_LoginConrol']//table//tr[4]/td")
    WebElement errorMessageLabel;

    public LoginPage(SeleniumFramework framework) {
        super(framework);
        PageFactory.initElements(framework.getDriver(),this);
    }
    
    public boolean verifyLoads(){
        return 
            seleniumFramework.waitForElementEnabled(userNameTextfield) && 
            seleniumFramework.waitForElementEnabled(passwordTextfield) &&
            seleniumFramework.waitForElementEnabled(loginButton) &&
            seleniumFramework.waitForElementEnabled(rememberNextTimecheckBox) &&
            seleniumFramework.waitForElementEnabled(createAccountLink) &&
            seleniumFramework.waitForElementEnabled(forgotPasswordLink);
    }
    
    public void login(String username,String password){
        setUsername(username);
        setPassword(password);
        clickOnLoginButton();
    }
    
    public void setUsername(String username){
        seleniumFramework.typeOnElement(userNameTextfield, username);
    }
    
    public void setPassword(String password){
        seleniumFramework.typeOnElement(passwordTextfield, password);
    }
    
    public void clickOnLoginButton(){
        seleniumFramework.clickOnElement(loginButton);
    } 
    
    public boolean verifyErrorMessage(String expectedErrorMessage){
        boolean verifyIfErrorMessageIsEqualsToExpected = isErrorMessageDisplayed() && isCurrentMessageAsExpectedMessage(expectedErrorMessage);
        
        return verifyIfErrorMessageIsEqualsToExpected;
    }
    
    public boolean isErrorMessageDisplayed(){
        return seleniumFramework.waitForElementVisible(errorMessageLabel);
    }
    
    private boolean isCurrentMessageAsExpectedMessage(String expectedErrorMessage){
        return getErrorMessage().equals(expectedErrorMessage);
    }
    
    public String getErrorMessage(){
        return seleniumFramework.getTextFromElement(errorMessageLabel);
    }
   
}
