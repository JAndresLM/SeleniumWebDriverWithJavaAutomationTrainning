// --------------------------------------------------------------
// <copyright file="SeleniumFramework.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Base Class With General Methods and attributes to use in 
//     every POM class
// </summary>
// ---------------------------------------------------------------

package pages;

import utilities.SeleniumFramework;

/**
 *
 * @author jlopezm-as
 */
public class BasePage {
    protected SeleniumFramework seleniumFramework;

    public BasePage(SeleniumFramework framework) {
        this.seleniumFramework = framework;
    }
    
    public String getTabTitle(){
        return seleniumFramework.getTitle();
    }
    
    public boolean verifyTabTitle(String expectedTitle){
        return getTabTitle().equals(expectedTitle);
    }
}
