package Interview.tencent.s;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-06 20:53
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        //创建对应表
        int[][] table = new int[m][];
        //table赋值
        int start = 0;
        for (int i = 0; i < m; i++) {
            table[i] = new int[reader.nextInt()];
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = reader.nextInt();
                if (table[i][j]==0) start = i;
            }
        }
        MySet pass = new MySet();
        int i = start;
        pass.add(table[start], start);
        while (pass.head<pass.list.size()) {
            int current = pass.list.get(pass.head);
            for (int j = 0; j < table.length; j++) {
                if (pass.ifAdd.contains(j)) continue;
                if (include(table[j], current)) {
                    pass.add(table[j],j);
                }
            }
            pass.head++;

        }
        System.out.println(pass.list.size());


    }

    private static boolean include(int[] ints, int current) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i]==current) return true;
        }
        return false;
    }

    private static class MySet {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> ifAdd = new HashSet<>();
        int head = 0;

        boolean contains(int val) {
            return list.contains(val);
        }

        boolean add(int val) {
            if (!list.contains(val)) {
                list.add(val);
                return true;
            }
            return false;
        }

        boolean add(int[] arr, int i) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                flag|=add(arr[j]);
            }
            ifAdd.add(i);
            return flag;
        }

        //是否有交集
        boolean Intersection(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (list.contains(arr[i])) {
                    return true;
                }
            }
            return false;
        }

        boolean ifAdd(int i) {
            return ifAdd.contains(i);
        }


    }
}
