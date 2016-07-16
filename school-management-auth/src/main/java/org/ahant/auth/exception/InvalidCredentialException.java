package org.ahant.auth.exception;

/**
 * Created by ahant on 3/19/2016.
 */
public class InvalidCredentialException extends RuntimeException {

    public InvalidCredentialException(String message){
        super(message);
    }

}
