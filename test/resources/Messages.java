// --------------------------------------------------------------
// <copyright file="Messages.java" company="Company Name">
//     Copyright (c) CompanyName. All rights reserved.
// </copyright>
// <summary>
//     Resource Class to define error messages in test classes
// </summary>
// ---------------------------------------------------------------

package resources;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author Andres Lopez Molina
 */
public class Messages {
    public static final String MAIN_MENU_WAS_NOT_LOADED_SUCCESSFUL = "Main menu was not loaded successfully";
    public static final String MAIN_PAGE_ELEMENTS_WERE_NOT_LOADED_SUCCESSFUL = "Main page elements were not loaded successfully";
    
    public static final String LOGIN_WAS_NOT_SUCCESSFUL = "Your login attempt was not successful. Please try again.";
    
    public static final String USERNAME_ALREADY_EXISTS = "User name already exists. Please enter a different user name.";
    public static final String PASSWORD_AND_CONFIRM_PASSWORD_MUST_MATCH = "The password and confirmation password must match.";
    public static final String VALID_EMAIL_IS_REQUIRED = "A valid and correct email is required.";
    
    public static final String FIRSTNAME_REQUIRED = "First name is required.";
    public static final String LASTNAME_REQUIRED = "Last name is required.";
    public static final String EMAIL_REQUIRED = "Email is required.";
    public static final String USERMAME_REQUIRED = "User name is required.";
    public static final String PASSWORD_REQUIRED = "Password is required.";
    public static final String CONFIRM_PASSWORD_REQUIRED = "Confirm password is required.";
    public static final String SECURITY_QUESTION_REQUIRED = "Security question is required.";
    public static final String SECURITY_ANSWER_REQUIRED = "Security answer is required.";
    
    public static final ArrayList<String> TEXTFIELDS_REQUIRED_LIST = new ArrayList(
        Arrays.asList(
            FIRSTNAME_REQUIRED,
            LASTNAME_REQUIRED,
            EMAIL_REQUIRED,
            USERMAME_REQUIRED,
            PASSWORD_REQUIRED,
            CONFIRM_PASSWORD_REQUIRED,
            SECURITY_QUESTION_REQUIRED,
            SECURITY_ANSWER_REQUIRED
        )
    );
}
