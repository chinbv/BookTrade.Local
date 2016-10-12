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
//
//        User user = new User(username, password, email);
        //Temporary test object to ensure that the code functions
//        User user = new User("brandon", "123456", "bvc@123.com");
//        _dbHandler.addUser(user);
//        user = new User("moriah", "123456", "mh@123.com");
//        _dbHandler.addUser(user);
//        user = new User("vishy", "123456", "vs@123.com");
//        _dbHandler.addUser(user);
    }

    public User addingUser(String userName, String password, String email) {

        User user = new User(userName, password, email);
        _dbHandler.addUser(user);

        return user;
    }

    public boolean authenticate(String userName, String password) {

//        System.out.println("username is " + userName);
//        System.out.println("password is " + password);

        if (userName == null || password == null) {
            return false;
        }

        User matchingUser = _dbHandler.findUserWithUserName(userName);
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
