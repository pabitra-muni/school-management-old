package org.ahant.core.validation;

import java.util.Set;

/**
 * Created by ahant on 8/14/2016.
 */
@FunctionalInterface
interface FieldValidator<T> {
    Set<String> validate(T input);
}
