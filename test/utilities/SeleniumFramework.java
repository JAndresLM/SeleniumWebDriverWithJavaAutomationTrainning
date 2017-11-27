// --------------------------------------------------------------
// <copyright file="SeleniumFramework.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     All fuctionalities related to Selenium Web Driver
//     are coded here
// </summary>
// ---------------------------------------------------------------

package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Tags;

/**
 * @author Andres Lopez Molina
 */
public class SeleniumFramework {
    
    private final WebDriver driver;
    private final String BASE_URL;
    private final int TIME_TO_WAIT;
    
    public SeleniumFramework(WebDriver otherDriver) {
        driver = otherDriver;
        BASE_URL = Tags.appUrl;
        TIME_TO_WAIT = Tags.TIME_TO_EXPLICIT_WAITS;
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    public boolean goToPage(String path){
        try {
            //driver.get(BASE_URL + path);
            driver.get(String.format("%s%s", BASE_URL, path));
            return true;
            
        } catch (Exception e) {
            return false;
        }  
    }
    
    public boolean closeDriver(){
        try {
            driver.quit();
            return true;
            
        } catch (Exception e) {
            return false;
        }  
    }
    
    public boolean typeOnElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            return true;
            
        } catch (Exception e) {
            return false;
        }  
    }
 
    public String getTextFromElement(WebElement element){
        try {
            return element.getText();
            
        } catch (Exception e) {
            return "";
        }
    }
    
    public String getTitle(){
        try {
            return driver.getTitle();
            
        } catch (Exception e) {
            return "";
        }
    }
 
    public boolean clickOnElement(WebElement element){
        try {
            element.click();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean selectOptionByValueFromMultipleSelectElement(Select multipleSelectElement, String value){
        try {
            multipleSelectElement.selectByValue(value);
            return true; 
        } catch (Exception e) {
            return false;
        } 
    }
    
    public String getTextOfSelectedOptionFromMultipleSelectElement(Select multipleSelectElement){
        try {
            return multipleSelectElement.getFirstSelectedOption().getText();
        } catch (Exception e) {
            return "";
        } 
    }
    
    public boolean isElementPresent(By searchCriteria){
        try {
            driver.findElement(searchCriteria);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } 
    }
    
    public boolean waitForElementVisible(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
            
        } catch (Exception e) {
            return false;
        } 
    }
    
    public boolean waitForElementVisible(By searchCriteria){
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchCriteria));
            return true;
            
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean waitForElementEnabled(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        } 
    }
    
    public boolean waitForElementsListEnabled(List<WebElement> elements){
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
            for (int index=0;index<elements.size();index++){
                 wait.until(ExpectedConditions.elementToBeClickable(elements.get(index)));
            }
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean waitForElementNotVisible(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true; 
        } catch (Exception e) {
            return false;
        } 
    }

}
