package org.ahant.core.validation;

import java.text.SimpleDateFormat;

import static org.ahant.core.constants.ApplicationConstants.*;

/**
 * Created by ahant on 8/14/2016.
 */
public enum FieldValidatorType {
    DEFAULT(new DefaultFieldValidator()),
    STRING(new StringFieldValidator()),
    PHONE(new StringFieldValidator(PHONE_NUMBER_REGEX, INVALID_PHONE)),
    ZIP(new StringFieldValidator(ZIP_CODE_REGEX, INVALID_ZIP, 6)),
    EMAIL(new StringFieldValidator(EMAIL_REGEX, INVALID_EMAIL, 30)),
    ADDRESS(new AddressFieldValidator()),
    BIRTH_DATE(new DateFieldValidator(new SimpleDateFormat(BIRTH_DATE_FORMAT)));

    private FieldValidator validator;

    FieldValidatorType(FieldValidator validator) {
        this.validator = validator;
    }

    public FieldValidator get() {
        return validator;
    }
}
