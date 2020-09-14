package test.testAnnotation;

import java.lang.annotation.Annotation;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-14 16:02
 */
@GanTa(times = 10,method = "upAndDown")
public class testAnnotation {

    public static void main(String[] args) throws NoSuchFieldException {
        testAnnotation testAnnotation = new testAnnotation();
        Annotation[] annotations = testAnnotation.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if ("test.testAnnotation.GanTa".equals(annotation.annotationType().getName())) {
                System.out.println("Ganta!");
                GanTa ganTa = (GanTa) annotation;
                System.out.println(ganTa.method());
                System.out.println(ganTa.times());
            }
        }
    }
}
