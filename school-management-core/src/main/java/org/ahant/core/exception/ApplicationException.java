package org.ahant.core.exception;

import org.ahant.core.model.Result;

/**
 * Created by ahant on 3/20/2016.
 */
public class ApplicationException extends ResultException{
    public ApplicationException(String message){
        super(message);
    }
}
