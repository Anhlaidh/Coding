package Java.JavaLearning_Advanced.Json;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/26 0026 21:20
 */
@Data
public class Person {
    private String name;
    private int age;
    private List<Integer> scores;
}
