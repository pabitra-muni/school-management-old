package org.ahant.controller.login;

import org.ahant.exception.InvalidCredentialException;
import org.ahant.model.login.User;

/**
 * Created by ahant on 3/19/2016.
 */
public interface LoginValidator {

	boolean validateUser(User user) throws IllegalArgumentException, InvalidCredentialException;

}
