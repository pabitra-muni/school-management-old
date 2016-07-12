package org.ahant.controller;

import org.ahant.exception.InvalidCredentialException;
import org.ahant.model.User;

/**
 * Created by ahant on 3/19/2016.
 */
public interface LoginValidator {

	boolean validateUser(User user) throws IllegalArgumentException, InvalidCredentialException;

}
