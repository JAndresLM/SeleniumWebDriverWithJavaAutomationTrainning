// --------------------------------------------------------------
// <copyright file="MyAdsAndProfile.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All test methods from My Ads and profile page are here
// </summary>
// ---------------------------------------------------------------
package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAdsAndProfilePage;
import pages.NavigationPage;
import resources.Messages;
import resources.PageNames;

/**
 * @author Andres Lopez Molina
 */
public class MyAdsAndProfileTest extends BaseTest{
    NavigationPage navigationPage;
    LoginPage loginPage;
    MyAdsAndProfilePage myAdsAndProfilePage;
    
    public void runPostAnAdTestsPreconditions(){
        navigationPage = new NavigationPage(seleniumFramework);
        assertTrue(navigationPage.verifyLoads(),Messages.MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatLoginPageIsDisplayedWhenUserClickPostAnAdTabAndUserIsNotLogged(){
        runPostAnAdTestsPreconditions();
        navigationPage.goToMyAdsAndProfilePage();
        loginPage = new LoginPage(seleniumFramework);
        assertTrue(loginPage.verifyTabTitle(PageNames.LOGIN_PAGE));
        assertTrue(loginPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatPostAnAdPageIsDisplayedWhenUserClickPostAnAdTabAndUserIsLogged(){
        runPostAnAdTestsPreconditions();
        loginPage = navigationPage.goToLoginPage();
        loginPage.login("alopez", "AndresLM#123");
        myAdsAndProfilePage = navigationPage.goToMyAdsAndProfilePage();
        assertTrue(myAdsAndProfilePage.verifyTabTitle(PageNames.MY_ADS_PROFILE_PAGE));
        assertTrue(myAdsAndProfilePage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
}
