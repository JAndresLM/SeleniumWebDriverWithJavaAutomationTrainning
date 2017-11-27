// --------------------------------------------------------------
// <copyright file="PostAnAdPage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Post Ads Page
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
public class PostAnAdPage extends BasePage{
    @FindBy(id="ctl00_Main_PostAdWizard_CategoryPath_AllCategoriesButton")
    WebElement allCategoriesLink;
    
    @FindBys({
        @FindBy(xpath="//table[@id='ctl00_Main_PostAdWizard_SubcategoriesList']//a[contains(@id,'ctl00_Main_PostAdWizard_SubcategoriesList_ct')]")
    })
    List<WebElement> categoriesListLinks;
    
    @FindBy(id="ctl00_Main_PostAdWizard_StartNavigationTemplateContainerID_StartNextButton")
    WebElement nextButton;

    public PostAnAdPage(SeleniumFramework framework) {
        super(framework);
        PageFactory.initElements(framework.getDriver(),this);
    }
    
    public boolean verifyLoads(){
        return 
            seleniumFramework.waitForElementEnabled(allCategoriesLink) && 
            seleniumFramework.waitForElementsListEnabled(categoriesListLinks) &&
            seleniumFramework.waitForElementEnabled(nextButton);
    }
    
}
