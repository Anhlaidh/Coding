package test.testAnnotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GanTa {
    int times() default 0;
    String method() default "doNothing";

}
