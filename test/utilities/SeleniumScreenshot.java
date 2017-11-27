/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author jlopezm-as
 */
public class SeleniumScreenshot {
    public static String takeScreenshot(WebDriver driver,String screenshotName){
        try{
            TakesScreenshot ts=(TakesScreenshot)driver;
            
            File source=ts.getScreenshotAs(OutputType.FILE);
            String dest = "C:/Selenium/reports/Screenshots/"+screenshotName+".png";
            File destination =  new File(dest);
            
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot taken");
            
            return dest;
        } 
        catch (Exception e){
            System.out.println("Exception while taking screenshot "+e.getMessage());
            return e.getMessage();
        } 
    }
}
