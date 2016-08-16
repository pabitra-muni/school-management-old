package org.ahant.core.annotation;

import org.ahant.core.validation.FieldValidatorType;

import java.lang.annotation.*;

/**
 * Created by ahant on 8/14/2016.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldInfo {
    String name() default "";
    boolean optional() default false;
    FieldValidatorType validatorType() default FieldValidatorType.DEFAULT;
}
