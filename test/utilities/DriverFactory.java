// --------------------------------------------------------------
// <copyright file="DriverFactory.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Factory to create local driver in normal mode 
//     or remote driver to use selenium grid
// </summary>
// ---------------------------------------------------------------
package utilities;

import java.net.MalformedURLException;
import resources.Tags;

/**
 * @author Andres Lopez Molina
 */
public class DriverFactory {
    public static IDriver createDriver(String mode) throws MalformedURLException{
        IDriver driver;
        
        if (mode.equalsIgnoreCase(Tags.REMOTE_MODE)){
            driver = new RemoteDriver();
        }else {
            driver = new LocalDriver();
        }
        
        return driver;
    }
    
}
