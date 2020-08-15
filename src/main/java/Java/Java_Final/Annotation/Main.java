package Java.Java_Final.Annotation;

import java.lang.reflect.Method;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-05 16:12
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "Java.Java_Final.Annotation.Foo";
        int passed = 0;
        int failed = 0;
        Method[] methods = Class.forName(className).getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable e) {
                    e.printStackTrace();
                    System.out.printf("Test %s failed %s %n", m, e.getCause().getMessage());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d ,Failed %d %n", passed, failed);
    }
}
