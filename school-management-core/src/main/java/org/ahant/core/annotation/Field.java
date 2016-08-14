package org.ahant.core.annotation;

import java.lang.annotation.*;

/**
 * Created by ahant on 8/14/2016.
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    String name() default "";
    boolean optional() default false;
}
