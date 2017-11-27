// --------------------------------------------------------------
// <copyright file="BrowseAllCategoriesPage.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     POM Class to map elements and create actions of Browse all categories Page
// </summary>
// ---------------------------------------------------------------

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.SeleniumFramework;

/**
 * @author Andres Lopez Molina
 */
public class BrowseAllCategoriesPage extends BasePage{
    @FindBy(id="ctl00_Main_SearchTermTextBox")
    WebElement searchTextField;
    
    @FindBy(id="ctl00_Main_CategoryDropDown_CategoryList")
    WebElement categoriesDropdown;
    
    @FindBy(id="ctl00_Main_SubcategoriesList")
    WebElement categoriesListView;
    
    @FindBy(id="ctl00_Main_SearchButton")
    WebElement searchButton;
    
    @FindBy(id="ctl00_Main_AdvancedSearchLink")
    WebElement goToAdvanceSearchLink;
    
    Select categoriesListViewSelect;
    Select categoriesDropdownSelect;
    
    public BrowseAllCategoriesPage(SeleniumFramework framework) {
        super(framework);
        PageFactory.initElements(framework.getDriver(),this);
        categoriesListViewSelect = new Select(categoriesListView);
        categoriesDropdownSelect = new Select(categoriesDropdown);
    }
    
    public boolean verifyLoads(){
        return 
            seleniumFramework.waitForElementEnabled(searchTextField) && 
            seleniumFramework.waitForElementEnabled(categoriesDropdown) && 
            seleniumFramework.waitForElementEnabled(categoriesListView) && 
            seleniumFramework.waitForElementEnabled(goToAdvanceSearchLink) && 
            seleniumFramework.waitForElementEnabled(searchButton);
    }
    
    public void setSearchTextfield(String searchCriteria){
        seleniumFramework.typeOnElement(searchTextField, searchCriteria);
    }
    
    public void selectCategoryFromListView(String value){
        seleniumFramework.selectOptionByValueFromMultipleSelectElement(categoriesListViewSelect, value);
    }
    
    public void selectCategoryFromDropdown(String value){
        seleniumFramework.selectOptionByValueFromMultipleSelectElement(categoriesDropdownSelect, value);
    }
    
    public String getSelectedOptionTextFromCategoriesDropdown(){
        return seleniumFramework.getTextOfSelectedOptionFromMultipleSelectElement(categoriesDropdownSelect);
    }
    
    public void clickOnSearchButton(){
        seleniumFramework.clickOnElement(searchButton);
    }
    
    public boolean verifyFocusAfterSelectCategory(String expectedCategory){
        String currentCategory = getSelectedOptionTextFromCategoriesDropdown();
        return currentCategory.contains(expectedCategory);
    }
    
}
