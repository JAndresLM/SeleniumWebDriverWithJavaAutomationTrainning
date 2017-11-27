// --------------------------------------------------------------
// <copyright file="BrowseAllCategoriesTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All test methods from Browse All Categories page are here
// </summary>
// ---------------------------------------------------------------

package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.BrowseAllCategoriesPage;
import pages.LoginPage;
import pages.NavigationPage;
import resources.Categories;
import resources.Messages;

/**
 * @author Andres Lopez Molina
 */
public class BrowseAllCategoriesTest extends BaseTest{
    NavigationPage navigationPage;
    LoginPage loginPage;
    BrowseAllCategoriesPage browseAllCategoriesPage;
    
    public void runBrowseAllCategoriesTestsPreconditions(){
        navigationPage = new NavigationPage(seleniumFramework);
        assertTrue(navigationPage.verifyLoads(),Messages.MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL);
        
        loginPage = navigationPage.goToLoginPage();
        assertTrue(loginPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
        loginPage.login("alopez", "AndresLM#123");
        
        browseAllCategoriesPage = navigationPage.goToBrowseAllCategoriesPage();
        assertTrue(browseAllCategoriesPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatSearchViewIsDisplayedWithAntiquestAndCollectiblesAsFocusWhenUserClicksOnAntiquesAndCollectivesCategoryFromListView(){
        runBrowseAllCategoriesTestsPreconditions();
        browseAllCategoriesPage.selectCategoryFromListView(Categories.ANTIQUES_AND_COLLECTIBLES_VALUE);
        assertTrue(browseAllCategoriesPage.verifyFocusAfterSelectCategory(Categories.ANTIQUES_AND_COLLECTIBLES_TEXT));
    }
    
    @Test
    public void testVerifyThatSearchViewIsDisplayedWithArtsAndCraftsAsFocusWhenUserClicksOnArtsAndCraftsCategoryFromListView(){
        runBrowseAllCategoriesTestsPreconditions();
        browseAllCategoriesPage.selectCategoryFromListView(Categories.ARTS_AND_CRAFTS_VALUE);
        assertTrue(browseAllCategoriesPage.verifyFocusAfterSelectCategory(Categories.ARTS_AND_CRAFTS_TEXT));
    }
    
    @Test
    public void testVerifyThatSearchViewIsDisplayedWithAutoAsFocusWhenUserClicksOnAutoCategoryFromListView(){
        runBrowseAllCategoriesTestsPreconditions();
        browseAllCategoriesPage.selectCategoryFromListView(Categories.AUTO_VALUE);
        assertTrue(browseAllCategoriesPage.verifyFocusAfterSelectCategory(Categories.AUTO_TEXT));
    }
    
    @Test
    public void testVerifyThatSearchViewIsDisplayedWithGardenAsFocusWhenUserClicksOnGardenCategoryFromListView(){
        runBrowseAllCategoriesTestsPreconditions();
        browseAllCategoriesPage.selectCategoryFromListView(Categories.GARDEN_VALUE);
        assertTrue(browseAllCategoriesPage.verifyFocusAfterSelectCategory(Categories.GARDEN_TEXT));
    }
    
    @Test
    public void testVerifyThatSearchViewIsDisplayedWithHomeAsFocusWhenUserClicksOnHomeCategoryFromListView(){
        runBrowseAllCategoriesTestsPreconditions();
        browseAllCategoriesPage.selectCategoryFromListView(Categories.HOME_VALUE);
        assertTrue(browseAllCategoriesPage.verifyFocusAfterSelectCategory(Categories.HOME_TEXT));
    }
}
