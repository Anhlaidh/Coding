package Java.JavaLearning.javaIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/22 0022 20:03
 */
public class testRead {
    public static void main(String[] args) {
        method_1();
        System.out.println("===============");
        method_2();
    }

    public static void method_1() {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            fileInputStream = new FileInputStream("./temp/abc.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
//            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("./temp/abc.txt")));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void method_2() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("./temp/abc.txt")))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
