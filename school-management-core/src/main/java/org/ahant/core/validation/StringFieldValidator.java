package org.ahant.core.validation;

import static org.ahant.core.util.CommonUtil.isNotBlank;

/**
 * Created by ahant on 8/14/2016.
 */
class StringFieldValidator implements FieldValidator<String> {

    private String regEx;

    StringFieldValidator() {
    }

    StringFieldValidator(String regEx) {
        this.regEx = regEx;
    }

    @Override
    public boolean validate(String input) {
        boolean returnValue = false;
        if (isNotBlank(input)) {
            returnValue = isNotBlank(regEx) ? input.matches(regEx) : true;
        }
        return returnValue;
    }
}
