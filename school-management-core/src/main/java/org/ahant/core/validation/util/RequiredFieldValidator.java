package org.ahant.core.validation.util;

import org.ahant.core.annotation.Required;
import org.ahant.core.exception.ApplicationException;

import java.lang.reflect.Field;

import static com.google.common.base.Preconditions.checkArgument;
import static org.ahant.core.constants.ApplicationConstants.REQUIRED_FIELD_MISSING;
import static org.ahant.core.util.CommonUtil.log;

/**
 * Created by ahant on 8/14/2016.
 */
public class RequiredFieldValidator {

    /**
     * Get all the declared fields of 'type' object and invoke their respective field validators. throw exception if validator returns false.
     * The thrown exception must be of type Application exception with message as required field missing along with field name.
     */
    public static boolean validate(Object type) throws ApplicationException {
        checkArgument(type != null, "type can't be null");
        Required typeLevelRequiredAnnotation = type.getClass().getAnnotation(Required.class);
        if(typeLevelRequiredAnnotation != null){
            performTypeLevelValidation(type);
        }else {
            log(RequiredFieldValidator.class, String.format("Annotation 'Required' is not present for class %s, checking for every field.", type.getClass().getName()));
        }
        return false;
    }

    // assumes all declared fields are required unless explicit 'optional' attribute is mentioned.
    private static void performTypeLevelValidation(Object type) {
        Field[] fields = type.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
        }
    }

    private String getExceptionMessage(String propertyName) {
        return String.format(REQUIRED_FIELD_MISSING, propertyName);

    }
}
