// --------------------------------------------------------------
// <copyright file="RemoteDriver.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Class to create remote drivers to use with selenium grid
// </summary>
// ---------------------------------------------------------------
package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import resources.Tags;

/**
 * @author Andres Lopez Molina
 */
public class RemoteDriver implements IDriver{
    private ThreadLocal<RemoteWebDriver> remoteDriver;
    private URL hubUrl;
    DesiredCapabilities capabilities;
    
    public RemoteDriver() throws MalformedURLException{
        hubUrl = new URL(Tags.HUB_URL);
        remoteDriver = new ThreadLocal<>();
        capabilities = new DesiredCapabilities();
    }

    @Override
    public void buildDriver(String browserType, String platform) {
        RemoteWebDriver driver;
        
        setBrowserOnCapabilities(browserType);
        setPlatformOnCapabilities(platform);
        
        driver = new RemoteWebDriver(hubUrl, capabilities);
        remoteDriver.set(driver);
    }

    @Override
    public WebDriver getDriverInstance() {
        return remoteDriver.get();
    }
    
    private void setBrowserOnCapabilities(String browser){
        switch (browser){
            case Tags.CHROME_BROWSER:
                capabilities=DesiredCapabilities.chrome();
                break;
            default://FIREFOX_BROWSER
                capabilities=DesiredCapabilities.firefox();
        }
        capabilities.setBrowserName(browser);
    }
    
    private void setPlatformOnCapabilities(String platform){
        if (platform.equalsIgnoreCase(Tags.LINUX_OS)){
            capabilities.setPlatform(Platform.LINUX);  
        }else{
            capabilities.setPlatform(Platform.WINDOWS);
        }
    }
    
}
