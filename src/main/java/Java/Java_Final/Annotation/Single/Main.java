package Java.Java_Final.Annotation.Single;

import java.lang.reflect.Method;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-05 17:18
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        int passed = 0, failed = 0;
        String className = "Java.Java_Final.Annotation.Single.Foo";
        for (Method m : Class.forName(className).getMethods()) {
            if (m.isAnnotationPresent(SingleTest.class)) {
                System.out.println(m.getName());
                SingleTest st = m.getAnnotation(SingleTest.class);
                try {
                    m.invoke(null, st.value());
                    passed++;
                } catch (Throwable throwable) {
                    System.out.printf("Test %s failed %s %n", m, throwable.getCause().getMessage());
                    failed++;
                }
            }
        }
        System.out.printf("Success: %d ,Failed: %d %n", passed, failed);
    }
}
