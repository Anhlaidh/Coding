package Java.JavaLearning.JCF.List;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/27 0027 19:14
 */
public class testList {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        List<Integer> list = Arrays.asList(arr);
        List<Integer> list1 = Arrays.asList(arr);
    }
}
