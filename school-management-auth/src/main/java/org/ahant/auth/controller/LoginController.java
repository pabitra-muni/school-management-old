package org.ahant.auth.controller;

import org.ahant.auth.model.User;

/**
 * Created by ahant on 3/19/2016.
 */
public interface LoginController {

    boolean isValidUser(User user);
    User getUserDetails(User user);
    User validateAndGetDetails(User user);
}
