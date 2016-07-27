package org.ahant.core.exception;

import org.ahant.core.model.Result;

/**
 * Created by ahant on 7/27/2016.
 */
public class ResultException extends RuntimeException implements Result {
    public ResultException(String msg){
        super(msg);
    }
}
