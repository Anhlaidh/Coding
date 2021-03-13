package LeetCode.everyday;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-31 13:53
 */
public class q381 {
    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();

        collection.insert(1);
        collection.insert(10);
        collection.insert(10);
        collection.insert(100);
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < 100000; i++) {
            int cur = collection.getRandom();
            if (cur == 1) {
                a++;
            } else if (cur == 10) {
                b++;
            } else if (cur == 100) {
                c++;
            }
        }
        System.out.println("1 times"+a);
        System.out.println("10 times"+b);
        System.out.println("100 times"+c);
//        System.out.println(collection.insert(1));;
//        System.out.println(collection.insert(1));;
//        System.out.println(collection.insert(2));;
//        System.out.println(collection.getRandom());;
//        System.out.println(collection.remove(1));;
//        System.out.println(collection.getRandom());;


    }

    static class RandomizedCollection {
        HashMap<Integer,Integer> map ;
        int count;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            count = 0;
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
                count++;
                return true;
            } else {
                map.put(val, map.get(val) + 1);
                count++;
                return false;
            }
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                if (map.get(val) - 1 == 0) {
                    map.remove(val);
                } else {
                    map.put(val, map.get(val) - 1);
                }
                count--;
                return true;
            } else {
                return false;
            }

        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            Set<Integer> set = map.keySet();
            Iterator<Integer> iterator = set.iterator();
            int key = new Random().nextInt(count);
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                Integer times = map.get(next);
                key = key - times;
                if (key < 0) {
                    return next;
                }

            }
            return 0;

        }
    }
}
