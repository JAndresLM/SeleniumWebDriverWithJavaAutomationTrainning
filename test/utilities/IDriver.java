// --------------------------------------------------------------
// <copyright file="IDriver.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Interface that every driver class has to implements
// </summary>
// ---------------------------------------------------------------
package utilities;

import org.openqa.selenium.WebDriver;

/**
 * @author Andres Lopez Molina
 */
public interface IDriver {
    public void buildDriver(String browserType, String platform);
    public WebDriver getDriverInstance();   
}
