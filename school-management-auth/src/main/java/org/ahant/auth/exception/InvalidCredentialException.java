package org.ahant.auth.exception;

import org.ahant.core.exception.ResultException;

/**
 * Created by ahant on 3/19/2016.
 */
public class InvalidCredentialException extends ResultException {

    public InvalidCredentialException(String message){
        super(message);
    }

}
