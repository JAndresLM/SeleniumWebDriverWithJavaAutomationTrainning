// --------------------------------------------------------------
// <copyright file="MyAdsAndProfilePage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of My Ads Page
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
public class MyAdsAndProfilePage extends BasePage{
    @FindBy(xpath="//h2[@class='section']")
    WebElement myCurrentAdsLabel;
    
    @FindBys({
        @FindBy(xpath="//div[@id='content_header']//ul//a[contains(@id,'ctl00_Main_')]")
    })
    List<WebElement> goToListLinks;
    
    @FindBy(id="ctl00_Main_SearchButton")
    WebElement searchButton;
    
    public MyAdsAndProfilePage(SeleniumFramework framework) {
        super(framework);
        PageFactory.initElements(framework.getDriver(),this);
    }
    
    public boolean verifyLoads(){
        return 
            seleniumFramework.waitForElementEnabled(myCurrentAdsLabel) && 
            seleniumFramework.waitForElementsListEnabled(goToListLinks) &&
            seleniumFramework.waitForElementEnabled(searchButton);
    }
    
}
