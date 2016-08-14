package org.ahant.core.validation;

/**
 * Created by ahant on 8/14/2016.
 */
@FunctionalInterface
interface FieldValidator<T> {
    boolean validate(T input);
}
