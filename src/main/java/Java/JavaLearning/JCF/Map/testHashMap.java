package Java.JavaLearning.JCF.Map;

import java.util.HashMap;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 20:05
 */
public class testHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,null);
        hashMap.put(null,"abc");
        hashMap.put(1000,"aaa");
        hashMap.put(2,"bbb");
        hashMap.put(30000, "ccc");
        System.out.println(hashMap.containsValue("aaa"));
        System.out.println(hashMap.containsKey(30000));
        hashMap.put(30000, "ddd");
        System.out.println(hashMap.get(30000));
        hashMap.remove(2);
        System.out.println("size:" + hashMap.size());
        hashMap.clear();
    }
}
