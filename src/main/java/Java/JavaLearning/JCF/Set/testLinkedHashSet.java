package Java.JavaLearning.JCF.Set;

import java.util.LinkedHashSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 15:49
 */
public class testLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(null);
        lhs.add(1000);
        lhs.add(20);
        lhs.add(3);
        lhs.add(40000);
        lhs.add(5000000);
        lhs.add(3);//3重复
        lhs.add(null);//null重复
        System.out.println(lhs.size());//6
        if (!lhs.contains(6)) {
            lhs.add(6);
        }
        System.out.println(lhs.size());//7
        lhs.remove(4);
        System.out.println(lhs.size());//6
//        hs.clear();
//        System.out.println(hs.size());//0
        System.out.println("=== for循环遍历 ===");
        for (Integer item : lhs) {
            System.out.println(item);
        }
        System.out.println("===测试集合交集==");
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        LinkedHashSet<String> set2 = new LinkedHashSet<>();

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
