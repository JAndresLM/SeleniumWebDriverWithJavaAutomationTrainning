// --------------------------------------------------------------
// <copyright file="PostAnAdTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All test methods from Post An Ad page are here
// </summary>
// ---------------------------------------------------------------

package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationPage;
import pages.PostAnAdPage;
import resources.Messages;
import resources.PageNames;

/**
 * @author Andres Lopez Molina
 */
public class PostAnAdTest extends BaseTest{
    NavigationPage navigationPage;
    LoginPage loginPage;
    PostAnAdPage postAdPage;
    
    public void runPostAnAdTestsPreconditions(){
        navigationPage = new NavigationPage(seleniumFramework);
        assertTrue(navigationPage.verifyLoads(),Messages.MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatLoginPageIsDisplayedWhenUserClickPostAnAdTabAndUserIsNotLogged(){
        runPostAnAdTestsPreconditions();
        navigationPage.goToPostAnAdPage();
        loginPage = new LoginPage(seleniumFramework);
        assertTrue(loginPage.verifyTabTitle(PageNames.LOGIN_PAGE));
        assertTrue(loginPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
    
    @Test
    public void testVerifyThatPostAnAdPageIsDisplayedWhenUserClickPostAnAdTabAndUserIsLogged(){
        runPostAnAdTestsPreconditions();
        loginPage = navigationPage.goToLoginPage();
        loginPage.login("alopez", "AndresLM#123");
        postAdPage = navigationPage.goToPostAnAdPage();
        assertTrue(postAdPage.verifyTabTitle(PageNames.POST_AN_AD_PAGE));
        assertTrue(postAdPage.verifyLoads(),Messages.MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL);
    }
    
}
