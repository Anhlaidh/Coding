package Interview.Left.greedy;

import java.util.PriorityQueue;

/**
 * @Description: 哈夫曼树
 * @author: Anhlaidh
 * @date: 2020-09-16 21:20
 */
public class lessMoney {
    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
