package Java.JavaLearning.JCF.Map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 19:15
 */
public class testHashtable {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1000, "aaa");
        hashtable.put(2,"bbb");
        hashtable.put(30000, "ccc");
        System.out.println(hashtable.contains("aaa"));
        System.out.println(hashtable.containsValue("aaa"));//等价于contains
        System.out.println(hashtable.containsKey("aaa"));

        hashtable.put(30000, "ddd");//更新覆盖ccc
        System.out.println(hashtable.get(30000));
        hashtable.remove(2);
        System.out.println("size:" + hashtable.size());
        hashtable.clear();
        System.out.println("size:" + hashtable.size());

        for (int i = 0; i < 10000; i++) {
            hashtable.put(i, "a");
        }
        Iterator<Map.Entry<Integer, String>> iterator = hashtable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            //获取key
            Integer key = entry.getKey();
            //获取value
            String value = entry.getValue();
            System.out.println(key+""+value);
        }

    }
}
