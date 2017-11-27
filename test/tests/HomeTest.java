// --------------------------------------------------------------
// <copyright file="HomeTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All test methods from home page are here
// </summary>
// ---------------------------------------------------------------

package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NavigationPage;
import resources.Messages;
import resources.PageNames;

/**
 * @author Andres Lopez Molina
 */
public class HomeTest extends BaseTest{
    NavigationPage navigationPage;
    HomePage homePage;
    
    public void runHomeTestsPreconditions(){
        navigationPage = new NavigationPage(seleniumFramework);
        assertTrue(navigationPage.verifyLoads(),Messages.MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL);
        
        homePage = navigationPage.goToHomePage();
        assertTrue(homePage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatHomePageIsDisplayedWhenAppStarted(){
        homePage = new HomePage(seleniumFramework);
        assertTrue(homePage.verifyTabTitle(PageNames.HOME_PAGE));
        assertTrue(homePage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatHomePageIsDisplayedWhenUserClickLoginLink(){
        runHomeTestsPreconditions();
        assertTrue(homePage.verifyTabTitle(PageNames.HOME_PAGE));
    }
}
