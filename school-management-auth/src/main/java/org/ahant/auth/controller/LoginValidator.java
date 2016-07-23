package org.ahant.auth.controller;

import org.ahant.auth.model.User;
import org.ahant.auth.exception.InvalidCredentialException;

/**
 * Created by ahant on 3/19/2016.
 */
public interface LoginValidator {

	boolean validateUser(User user);

}
