package Interview.xc;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-13 11:38
 */
public class main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = reader.next();
            //定义
            if (!s.contains("=")) {
                int left = s.lastIndexOf("[");
                String name = s.substring(0, left);
                int right = s.indexOf("]");
                int size = Integer.parseInt(s.substring(left + 1, right));
                int[] arr = new int[size];
                map.put(name,arr);
                //赋值
            } else {
                StringBuffer a = new StringBuffer(s);
                int left = a.lastIndexOf("[");
                int right = a.indexOf("]");
                int index = Integer.parseInt(s.substring(left + 1, right));
//                a.replace(left,right,




            }
        }
    }

    static void replace(String s) {


    }
}
