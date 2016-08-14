package org.ahant.core.validation.util;

import org.ahant.core.exception.ApplicationException;
import static org.ahant.core.constants.ApplicationConstants.REQUIRED_FIELD_MISSING;

/**
 * Created by ahant on 8/14/2016.
 */
public class RequiredFieldValidator {

    /**
     * Get all the declared fields of 'type' object and invoke their respective field validators. throw exception if validator returns false.
     * The thrown exception must be of type Application exception with message as required field missing along with field name.
     */
    public static boolean validate(Object type) throws ApplicationException{
        return false;
    }

    private String getExceptionMessage(String propertyName){
        return String.format(REQUIRED_FIELD_MISSING, propertyName);

    }
}
