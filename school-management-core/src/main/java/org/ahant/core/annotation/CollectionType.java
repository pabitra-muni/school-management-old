package org.ahant.core.annotation;

import java.lang.annotation.*;

/**
 * Created by ahant on 8/17/2016.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionType {
    int minSize() default 1;
}
