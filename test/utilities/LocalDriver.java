// --------------------------------------------------------------
// <copyright file="BaseTest.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Class to create local drivers to use in normal way
// </summary>
// ---------------------------------------------------------------

package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import resources.Tags;

/**
 * @author Andres Lopez Molina
 */
public class LocalDriver implements IDriver {
    private WebDriver driver;

    @Override
    public void buildDriver(String browserType, String platform) {
        switch (browserType){
            case Tags.CHROME_BROWSER:
                System.setProperty("webdriver.chrome.driver","External Resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default://FIREFOX_BROWSER
                System.setProperty("webdriver.gecko.driver","External Resources/geckodriver.exe");
                driver = new FirefoxDriver();
        }
    }

    @Override
    public WebDriver getDriverInstance() {
        return driver;
    }
    
}
