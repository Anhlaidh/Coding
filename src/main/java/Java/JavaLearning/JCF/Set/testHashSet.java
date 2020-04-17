package Java.JavaLearning.JCF.Set;

import java.util.HashSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 15:01
 */
public class testHashSet {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(null);
        hs.add(1000);
        hs.add(20);
        hs.add(3);
        hs.add(40000);
        hs.add(5000000);
        hs.add(3);//3重复
        hs.add(null);//null重复
        System.out.println(hs.size());//6
        if (!hs.contains(6)) {
            hs.add(6);
        }
        System.out.println(hs.size());//7
        hs.remove(4);
        System.out.println(hs.size());//6
//        hs.clear();
//        System.out.println(hs.size());//0
        System.out.println("=== for循环遍历 ===");
        for (Integer item : hs) {
            System.out.println(item);
        }
        System.out.println("===测试集合交集==");
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set2.add("c");
        set2.add("d");
        set2.add("e");
        //交集
        set1.retainAll(set2);
        System.out.println("交集是" + set1);


    }
}
