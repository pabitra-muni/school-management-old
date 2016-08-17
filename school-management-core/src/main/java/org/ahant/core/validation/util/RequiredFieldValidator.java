package org.ahant.core.validation.util;

import com.google.common.collect.Sets;
import org.ahant.core.annotation.Required;
import org.ahant.core.validation.FieldValidationType;

import java.lang.reflect.Field;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static org.ahant.core.constants.ApplicationConstants.REQUIRED_FIELD_MISSING;

/**
 * Created by ahant on 8/14/2016.
 */
public class RequiredFieldValidator {

    /**
     * Get all the declared fields of 'type' object and invoke their respective field validators. throw exception if validator returns false.
     * The thrown exception must be of type Application exception with message as required field missing along with field name.
     */
    public static Set<String> validate(Object type, FieldValidationType validationType){
        checkArgument(type != null, "type can't be null");
        return performFieldValidation(type, validationType, type.getClass().getAnnotation(Required.class) != null);
    }

    /**
     * Iterates over all declared fields and performs validation.
     *
     * @param type                      type instance for which validation needs to be performed
     * @param validationType            If <code>FieldValidationType.FAIL_FAST</code>, the process terminates as soon as it encounters a failed scenario else continues validation.
     * @param requiredAnnotationPresent indicates if the given type object has 'Required' annotation at class level. If present, all of it's fields are considered as required
     *                                  unless explicitly mentioned as 'optional'.
     */
    private static Set<String> performFieldValidation(Object type, FieldValidationType validationType, boolean requiredAnnotationPresent) {
        Set<String> errors = Sets.newHashSet();
        Field[] fields = type.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }

        return errors;
    }

    private static String getExceptionMessage(String propertyName) {
        return String.format(REQUIRED_FIELD_MISSING, propertyName);

    }
}
