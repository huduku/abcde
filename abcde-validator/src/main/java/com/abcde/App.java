package com.abcde;

import com.abcde.check.User;
import com.abcde.check.UserValidator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        User user = new User();
        UserValidator userValidator = new UserValidator(user);
        boolean isPassCheck = userValidator.check();
        if (!isPassCheck) {
            for (String errMsg : userValidator.getErrMsgs()) {
                System.out.println(errMsg);
            }
        }
    }
}
