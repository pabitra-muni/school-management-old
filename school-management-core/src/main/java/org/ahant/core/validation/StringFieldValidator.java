package org.ahant.core.validation;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

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
    public Set<String> validate(String input) {
        boolean isValid = false;
        if (isNotBlank(input)) {
            isValid = isNotBlank(regEx) ? input.matches(regEx) : true;
        }
        return isValid ? null : ImmutableSet.of("Invalid value: "+input);
    }
}
