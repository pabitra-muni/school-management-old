package org.ahant.core.validation;

import java.text.DateFormat;
import java.text.ParseException;

/**
 * Created by ahant on 8/17/2016.
 */
public class DateFieldValidator implements FieldValidator<String> {

    private DateFormat formatter;

    public DateFieldValidator(DateFormat format) {
        this.formatter = format;
    }

    @Override
    public boolean validate(String input) {
        boolean returnValue = false;
        if (input != null && formatter != null) {
            try {
                formatter.setLenient(false);
                formatter.parse(input);
                returnValue = true;
            } catch (ParseException e) {
                // Ignore the exception and return false;
            }
        }
        return returnValue;
    }
}
