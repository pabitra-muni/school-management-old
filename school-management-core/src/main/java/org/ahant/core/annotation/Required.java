package org.ahant.core.annotation;

import java.lang.annotation.*;

/**
 * Created by ahant on 8/14/2016.
 */
@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    String name() default "";
    boolean allFields() default true;
}
