package com.cmsc355.curry_crackers_cats.booktrade;

import android.content.Context;

/**
 * Created by brandonc on 10/11/16.
 */

public class UserManager {

    private static UserManager _instance = null;

    private DBHandler _dbHandler = null;

    public UserManager(Context appContext) {

        _dbHandler = DBHandler.getInstanceWithContext(appContext);

        //Temporary test object to ensure that the code functions
        User user = new User("Name", "password", "email");
        _dbHandler.addUser(user);
    }

    public boolean authenticate(String userName, String password) {

        if (userName == null || password == null) {
            return false;
        }

        User matchingUser = findUserWithUserName (String userName);
        if (matchingUser == null) {
            return false;
        }

        if (matchingUser.getPassword().compareTo(password) == 0) {
            return true;
        }

        return false;

    }

    public static UserManager getInstanceWithContext(Context appContext ) {
        if (_instance == null) _instance = new UserManager(appContext);

        return _instance;
    }

}
