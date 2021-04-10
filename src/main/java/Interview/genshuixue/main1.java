package Interview.genshuixue;

import java.util.*;
/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-09 09:56
 */
public class main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[N/2]);
    }
}
