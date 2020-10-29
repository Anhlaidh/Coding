package LeetCode.everyday;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-24 16:00
 */
public class q1024 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        int[][] arr = new int[][]{{0, 1}, {1, 2}};
//        int[][] arr = new int[][]{{0, 4}, {2, 8}};
//        int[][] arr = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        q1024 q = new q1024();
        int i = q.videoStitching(arr, 10);
        System.out.println(i);

    }

    /**
     * 去除覆盖情况
     * 开始时间小的
     * 相同时间取结束时间晚的
     * 递归给下一个
     *
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {
        //去覆盖
        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(clips));
        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });

        ArrayList<int[]> result = new ArrayList<>();
        int process = process(list, 0, T, result);
        return process;
    }

    private int process(LinkedList<int[]> list, int i, int t, ArrayList<int[]> result) {
        if (list.peek() == null) {
            if (i < t) {
                return -1;
            } else {
                return 1;
            }
        }

        if (list.peek()!=null&&list.peek()[1] >= t) {
            result.add(list.pop());
            return 1;
        }
        //去重
        if (list.peek()[1] <= i) {
            list.removeFirst();
            return process(list, i, t, result);
        }

        LinkedList<int[]> cur = new LinkedList<>();
        cur.add(list.pop());
        while (list.peek() != null) {
            if (!(list.peek()[0] == cur.getFirst()[0])) break;
            cur.add(list.pop());
        }
        cur.sort((a, b) -> {
            return b[1] - a[1];
        });
        int[] pop = cur.pop();
        int[] peek = list.peek();
        if (peek == null && pop[1] < t) return -1;
        if (peek != null && pop[1] < peek[0]) return -1;
        result.add(pop);
        int process = process(list, pop[1], t, result);
        return process == -1 ? -1 : process + 1;

    }

}
