/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.testng.annotations.DataProvider;

/**
 *
 * @author jlopezm-as
 */
public class LoginData {
    @DataProvider(name = "incorrectUserNamesAndPasswords")
    public static Object[][] getIncorrectUserNamesAndPasswords() {
       return new Object[][] {
           {"Fernando", "Solis"}, 
           {"Andres", "Lopez"},
           {"Rebeca", "Najera"}, 
           {"Brian", "Salazar"},
           {"Laurens", "Chaves"}
       };
    }
}
