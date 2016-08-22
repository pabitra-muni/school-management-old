package org.ahant.core.validation;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static org.ahant.core.util.CommonUtil.isNotBlank;

/**
 * Created by ahant on 8/14/2016.
 */
class StringFieldValidator implements FieldValidator<String> {

    private String regEx;
    private String msg;
    private int maxLength;

    StringFieldValidator() {
    }

    StringFieldValidator(String regEx) {
        this(regEx, null, -1);
    }

    StringFieldValidator(String regEx, String msg) {
        this(regEx, msg, -1);
    }

    StringFieldValidator(String regEx, int maxLength) {
        this(regEx, null, maxLength);
    }

    StringFieldValidator(String regEx, String msg, int maxLength) {
        this.regEx = regEx;
        this.msg = msg;
        this.maxLength = maxLength;
    }

    @Override
    public Set<String> validate(String input) {
        boolean isValid = false;
        if (isNotBlank(input)) {
            isValid = true;
            if(maxLength > 0 ){
                isValid = input.length() <= maxLength;
            }
            if (isValid){
                isValid = isNotBlank(regEx) ? input.matches(regEx) : true;
            }
        }
        return isValid ? null : ImmutableSet.of(isNotBlank(msg) ? msg : "Invalid value: " + input);
    }
}
