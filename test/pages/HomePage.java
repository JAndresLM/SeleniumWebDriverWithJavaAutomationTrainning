// --------------------------------------------------------------
// <copyright file="HomePage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Home Page
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
public class HomePage extends BasePage{
    @FindBy(xpath=".//*[@id='col_main_right']/h3")
    WebElement categoriesTitleLabel;
    
    @FindBys({
        @FindBy(xpath="//table[@id='ctl00_Main_CategoryBrowser_TopCategoryList']//a[contains(@id,'ctl00_Main_CategoryBrowser_TopCategoryList')]")
    })
    List<WebElement> categoriesListLinks;

    public HomePage(SeleniumFramework framework) {
        super(framework);
        PageFactory.initElements(framework.getDriver(),this);
    }
    
    public boolean verifyLoads(){
        return seleniumFramework.waitForElementsListEnabled(categoriesListLinks) && seleniumFramework.waitForElementEnabled(categoriesTitleLabel);
    }
      
}
