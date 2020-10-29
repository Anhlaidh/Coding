package LeetCode.everyday;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-28 16:36
 */
public class q1207 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        System.out.println(uniqueOccurrences(arr));
        
    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> times = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!times.containsKey(arr[i])) {
                times.put(arr[i], 0);
            } else {
                times.put(arr[i], times.get(arr[i])+1);
            }
        }
        return hasSameTimes(times);

    }

    private static boolean hasSameTimes(HashMap<Integer, Integer> times) {
        HashSet<Integer> set = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> entries = times.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> cur = iterator.next();
            if (!set.contains(cur.getValue())) {
                set.add(cur.getValue());
            } else return false;
        }
        return true;
    }
}
