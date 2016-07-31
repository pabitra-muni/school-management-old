package org.ahant.core.exception;

/**
 * Created by ahant on 3/20/2016.
 */
public class ApplicationException extends ResultException {
    private static final String DEFAULT_EXCEPTION_MSG = "System error occurred, please check logs for more information";

    public ApplicationException() {
        this(DEFAULT_EXCEPTION_MSG);
    }

    public ApplicationException(String message) {
        super(message);
    }
}
