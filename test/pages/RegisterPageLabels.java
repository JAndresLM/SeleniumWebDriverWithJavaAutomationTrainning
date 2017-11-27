// --------------------------------------------------------------
// <copyright file="RegisterPageLabels.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Register Page
//     Specifically with label elements for errors
// </summary>
// ---------------------------------------------------------------

package pages;

import java.util.ArrayList;
import java.util.Arrays;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumFramework;

/**
 * @author Andres Lopez Molina
 */
public class RegisterPageLabels {
    private SeleniumFramework seleniumFramework;
    
    // Labels for error required messages
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired")
    WebElement firstNameRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired")
    WebElement lastNameRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired")
    WebElement emailRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired")
    WebElement usernameRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired")
    WebElement passwordRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired")
    WebElement confirmPasswordRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired")
    WebElement securityQuestionRequiredLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired")
    WebElement securityAnswerRequiredLabel;
    
    // labels for error format messages
    @FindBy(id="ctl00_Main_InfoLabel")
    WebElement userAlreadyExistLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare")
    WebElement passwordsMustMatchLabel;
    
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequiredFormat")
    WebElement validEmailRequiredLabel;
    
    ArrayList<WebElement> requiredLabels;
    
    public RegisterPageLabels(SeleniumFramework framework) {
        this.seleniumFramework = framework;
        PageFactory.initElements(framework.getDriver(),this);
        
        requiredLabels = new ArrayList(
            Arrays.asList(
                firstNameRequiredLabel,
                lastNameRequiredLabel,
                emailRequiredLabel,
                usernameRequiredLabel,
                passwordRequiredLabel,
                confirmPasswordRequiredLabel,
                securityQuestionRequiredLabel,
                securityAnswerRequiredLabel
            )
        );
    }
    
    public boolean verifyEveryRequiredFieldErrorMessage(ArrayList<String> expectedMessages){
        boolean result=true;
        boolean isMessageDisplayed;
        boolean areMessagesEquals;
        String currentMessage;
        String expectedMessage;
        
        for (int index=0;index<requiredLabels.size();index++){
            
            isMessageDisplayed=isErrorMessageDisplayed(requiredLabels.get(index));
            if (isMessageDisplayed){
                currentMessage=getErrorMessage(requiredLabels.get(index));
                expectedMessage=expectedMessages.get(index);
                areMessagesEquals=areCurrentMessageAndExpectedMessageEquals(currentMessage, expectedMessage);
                if (areMessagesEquals==false){
                    result=false;
                    break;
                }
            }else{
                result=false;
                break;
            }
        }
        
        return result;
    }
    
    public boolean verifyUserNameAlreadyExistsErrorMessage(String expectedErrorMessage){
        return (
            isErrorMessageDisplayed(userAlreadyExistLabel) && 
            areCurrentMessageAndExpectedMessageEquals(getErrorMessage(userAlreadyExistLabel), expectedErrorMessage)
        );
    }
    
    public boolean verifyPasswordsMustMatchErrorMessage(String expectedErrorMessage){
        return (
            isErrorMessageDisplayed(passwordsMustMatchLabel) && 
            areCurrentMessageAndExpectedMessageEquals(getErrorMessage(passwordsMustMatchLabel), expectedErrorMessage)
        );
    }
    
    public boolean verifyValidEmailRequiredErrorMessage(String expectedErrorMessage){
        return (
            isErrorMessageDisplayed(validEmailRequiredLabel) && 
            areCurrentMessageAndExpectedMessageEquals(getErrorMessage(validEmailRequiredLabel), expectedErrorMessage)
        );
    }
    
    private boolean areCurrentMessageAndExpectedMessageEquals(String currentMessage, String expectedMessage){
        return currentMessage.equals(expectedMessage);
    }
    
    private boolean isErrorMessageDisplayed(WebElement errorMessageLabel){
        return seleniumFramework.waitForElementVisible(errorMessageLabel);
    }
    
    private String getErrorMessage(WebElement errorMessageLabel){
        return seleniumFramework.getTextFromElement(errorMessageLabel);
    }
    
}
