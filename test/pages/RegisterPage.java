// --------------------------------------------------------------
// <copyright file="RegisterPage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Register Page
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
public class RegisterPage extends BasePage{
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")
    WebElement firstNameTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")
    WebElement lastNameTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")
    WebElement emailTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")
    WebElement usernameTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")
    WebElement passwordTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")
    WebElement securityQuestionTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")
    WebElement securityAnswerTextfield;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")
    WebElement submitButton;
    
    
    public RegisterPage(SeleniumFramework framework) {
        super(framework);
        PageFactory.initElements(framework.getDriver(),this);
    }
    
    public boolean verifyLoads(){
        return 
            seleniumFramework.waitForElementEnabled(firstNameTextfield) && 
            seleniumFramework.waitForElementEnabled(lastNameTextfield) &&
            seleniumFramework.waitForElementEnabled(emailTextfield) &&
            seleniumFramework.waitForElementEnabled(usernameTextfield) &&
            seleniumFramework.waitForElementEnabled(passwordTextfield) &&
            seleniumFramework.waitForElementEnabled(confirmPasswordTextfield) &&
            seleniumFramework.waitForElementEnabled(securityQuestionTextfield) &&
            seleniumFramework.waitForElementEnabled(securityAnswerTextfield) &&
            seleniumFramework.waitForElementEnabled(submitButton);
    }
    
    public void createNewUser(String firstname, String lastname, String email, String username, String password, String confirmPassword,String securityQuestion, String SecurityAnswer){
        setFirstName(firstname);
        setLastName(lastname);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        setSecurityQuestion(securityQuestion);
        setSecurityAnswer(SecurityAnswer);
        clickOnSubmitButton();
    }
    
    public void setFirstName(String firstName){
        seleniumFramework.typeOnElement(firstNameTextfield, firstName);
    }
    
    public void setLastName(String lastName){
        seleniumFramework.typeOnElement(lastNameTextfield, lastName);
    }
    
    public void setEmail(String email){
        seleniumFramework.typeOnElement(emailTextfield, email);
    }
    
    public void setUsername(String username){
        seleniumFramework.typeOnElement(usernameTextfield, username);
    }
    
    public void setPassword(String password){
        seleniumFramework.typeOnElement(passwordTextfield, password);
    }
    
    public void setConfirmPassword(String confirmPassword){
        seleniumFramework.typeOnElement(confirmPasswordTextfield, confirmPassword);
    }
    
    public void setSecurityQuestion(String securityQuestion){
        seleniumFramework.typeOnElement(securityQuestionTextfield, securityQuestion);
    }
    
    public void setSecurityAnswer(String securityAnswer){
        seleniumFramework.typeOnElement(securityAnswerTextfield, securityAnswer);
    }
    
    public void clickOnSubmitButton(){
        seleniumFramework.clickOnElement(submitButton);
    }
    
}
