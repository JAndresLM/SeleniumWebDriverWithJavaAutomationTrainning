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
public class ExtentManager {
    private static ExtentReports extent;
    
    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath);
            
            extent
                .addSystemInfo("Host Name", "Anshoo")
                .addSystemInfo("Environment", "QA");
        }
        
        return extent;
    }
}
