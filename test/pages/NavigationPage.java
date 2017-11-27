// --------------------------------------------------------------
// <copyright file="NavigationPage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Navigation Page
// </summary>
// ---------------------------------------------------------------

package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumFramework;

/**
 * @author Andres Lopez Molina
 */
public class NavigationPage {
    SeleniumFramework seleniumFramework;
    
    @FindBys({
        @FindBy(xpath="//div[@id='nav_header']//a[contains(@id,'ctl00_TopMenuRepeater_ct')]")
    })
    List<WebElement> topMenuLinks;
    
    @FindBy(id="ctl00_BrowseAllLink")
    WebElement browseAllCategoriesLink;
    
    @FindBy(id="ctl00_LoginView_LoginLink")
    WebElement loginLink;
    
    @FindBy(id="ctl00_LoginView_RegisterLink")
    WebElement registerLink;
    
    @FindBy(id="ctl00_LoginView_MemberName")
    WebElement usernameLabel;
    
    @FindBy(id="ctl00_LoginView_MemberLoginStatus")
    WebElement logoutLink;

    public NavigationPage(SeleniumFramework framework) {
        this.seleniumFramework = framework;
        PageFactory.initElements(framework.getDriver(),this);
    }
    
    public boolean verifyLoads(){
        return 
            seleniumFramework.waitForElementsListEnabled(topMenuLinks) && 
            seleniumFramework.waitForElementEnabled(browseAllCategoriesLink) &&
            seleniumFramework.waitForElementEnabled(loginLink) &&
            seleniumFramework.waitForElementEnabled(registerLink) &&
            seleniumFramework.waitForElementEnabled(loginLink);
    }
    
    public HomePage goToHomePage(){
        seleniumFramework.clickOnElement(topMenuLinks.get(0));
        return new HomePage(seleniumFramework);
    }
    
    public LoginPage goToLoginPage(){
        seleniumFramework.clickOnElement(loginLink);
        return new LoginPage(seleniumFramework);
    }
    
    public RegisterPage goToRegisterPage(){
        seleniumFramework.clickOnElement(registerLink);
        return new RegisterPage(seleniumFramework);
    }
    
    public PostAnAdPage goToPostAnAdPage(){
        seleniumFramework.clickOnElement(topMenuLinks.get(1));
        return new PostAnAdPage(seleniumFramework);
    }
    
    public MyAdsAndProfilePage goToMyAdsAndProfilePage(){
        seleniumFramework.clickOnElement(topMenuLinks.get(2));
        return new MyAdsAndProfilePage(seleniumFramework);
    }
    
    public BrowseAllCategoriesPage goToBrowseAllCategoriesPage(){
        seleniumFramework.clickOnElement(browseAllCategoriesLink);
        return new BrowseAllCategoriesPage(seleniumFramework);
    }
    
    public void logout(){
        seleniumFramework.clickOnElement(logoutLink);
    }
    
    public boolean verifyUsernameText(String expectedUsernameText){
        return (isUsernameLabelDisplayed() && getUsernameTextAfterLogin().equals(expectedUsernameText));
    }
    
    public boolean isUsernameLabelDisplayed(){
        return seleniumFramework.waitForElementVisible(usernameLabel);
    }
    
    public String getUsernameTextAfterLogin(){
        return seleniumFramework.getTextFromElement(usernameLabel);
    }
}
