/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.relevantcodes.extentreports.ExtentReports;

/**
 *
 * @author jlopezm-as
 */
public class Report {
    
    public static Report instance = null;
    private ExtentReports report;
    private static String nameOfFile;

    public Report(String fileName) {
        report = new ExtentReports("C:\\Selenium\\reports\\AutomationTraining["+fileName+"].html");
        nameOfFile = fileName;
    }

    public static Report getInstance() {
        if(instance == null) {
         instance = new Report(nameOfFile);
      }
        return instance;
    }

    public ExtentReports getReport() {
        return report;
    }

    public void setReport(ExtentReports report) {
        this.report = report;
    }
    
}
