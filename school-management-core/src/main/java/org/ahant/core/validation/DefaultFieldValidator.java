package org.ahant.core.validation;

/**
 * Created by ahant on 8/14/2016.
 */
class DefaultFieldValidator implements FieldValidator<Object> {
    @Override
    public boolean validate(Object input) {
        return null != input;
    }
}
