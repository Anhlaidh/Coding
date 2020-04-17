package Java.JavaLearning_Advanced.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/26 0026 21:42
 */
public class testJackson {
    public static void main(String[] args) throws IOException {
        testJsonObject();
        System.out.println("分割线=====================================================");
        testJsonFile();

    }

    private static void testJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //从json文件中加载，并重构为java对象
        File json = new File("temp/json/books.json");
        List<Book> books = objectMapper.readValue(json, new TypeReference<List<Book>>() {
        });
        for (Book book : books) {
            System.out.println(book.getAuthor());
            System.out.println(book.getTitle());
        }

    }

    private static void testJsonObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //构造对象
        Person person = new Person();
        person.setName("TOM");
        person.setAge(20);
        person.setScores(Arrays.asList(60, 70, 80));
        //将对象解析为json字符串
        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println(jsonStr);
        //json字符串重构对象
        Person p2 = objectMapper.readValue(jsonStr, Person.class);
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
        System.out.println(p2.getScores());
        //从json字符串重构JsonNode对象
        JsonNode node = objectMapper.readTree(jsonStr);
        System.out.println(node.get("name").asText());
        System.out.println(node.get("age").asText());
        System.out.println(node.get("scores"));

    }
}
