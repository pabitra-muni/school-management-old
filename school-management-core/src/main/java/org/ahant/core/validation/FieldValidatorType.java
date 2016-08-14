package org.ahant.core.validation;

import static org.ahant.core.constants.ApplicationConstants.EMAIL_REGEX;
import static org.ahant.core.constants.ApplicationConstants.PHONE_NUMBER_REGEX;
import static org.ahant.core.constants.ApplicationConstants.ZIP_CODE_REGEX;

/**
 * Created by ahant on 8/14/2016.
 */
public enum FieldValidatorType {
    DEFAULT(new DefaultFieldValidator()),
    STRING(new StringFieldValidator()),
    PHONE(new StringFieldValidator(PHONE_NUMBER_REGEX)),
    ZIP(new StringFieldValidator(ZIP_CODE_REGEX)),
    EMAIL(new StringFieldValidator(EMAIL_REGEX)),
    ADDRESS(new AddressFieldValidator());

    private FieldValidator validator;

    FieldValidatorType(FieldValidator validator) {
        this.validator = validator;
    }

    public FieldValidator get() {
        return validator;
    }
}
