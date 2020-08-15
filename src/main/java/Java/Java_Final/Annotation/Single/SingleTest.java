package Java.Java_Final.Annotation.Single;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-05 17:16
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleTest {
    int value();
}
