package Java.JavaLearning.JCF.Set;

import java.util.TreeSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 15:55
 */
public class testTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
//        ts.add(null); 错误，不支持null
        ts.add(1000);
        ts.add(20);
        ts.add(3);
        ts.add(40000);
        ts.add(5000000);
        ts.add(3);//3重复
//        ts.add(null);//null重复
        System.out.println(ts.size());//6
        if (!ts.contains(6)) {
            ts.add(6);
        }
        System.out.println(ts.size());//7
        ts.remove(4);
        System.out.println(ts.size());//6
//        hs.clear();
//        System.out.println(hs.size());//0
        System.out.println("=== for循环遍历 ===");
        for (Integer item : ts) {
            System.out.println(item);
        }
        System.out.println("===测试集合交集==");
        TreeSet<Object> set1 = new TreeSet<>();
        TreeSet<Object> set2 = new TreeSet<>();

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
