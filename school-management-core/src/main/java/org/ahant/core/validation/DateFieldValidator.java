package org.ahant.core.validation;

import com.google.common.collect.ImmutableSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

/**
 * Created by ahant on 8/17/2016.
 */
public class DateFieldValidator implements FieldValidator<String> {

    private SimpleDateFormat formatter;

    DateFieldValidator(SimpleDateFormat format) {
        this.formatter = format;
    }

    @Override
    public Set<String> validate(String input) {
        boolean isValid = false;
        if (input != null && formatter != null) {
            try {
                formatter.setLenient(false);
                formatter.parse(input);
                isValid = true;
            } catch (ParseException e) {
                // Ignore the exception and return error;
            }
        }
        return isValid ? null : ImmutableSet.of(String.format("Invalid date value \'%s\' for format %s", input, formatter.toPattern()));
    }
}
