package Interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-12 19:45
 */
public class Main3 {
    public static void main(String[] args) {

        //输入
        Scanner reader = new Scanner(System.in);
        int offSize = reader.nextInt();
        int[] offs = new int[offSize];
        int costSize = reader.nextInt();
        int[] costs = new int[costSize];
        for (int i = 0; i < offSize; i++) {
            offs[i] = reader.nextInt();
        }

        for (int i = 0; i < costSize; i++) {
            costs[i] = reader.nextInt();
        }

        System.out.println( solution(offs, costs));
    }

    private static int solution(int[] offs, int[] costs) {
        Arrays.sort(offs);
        Arrays.sort(costs);
        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            int off = findOff(costs[i],offs,offs.length/2);


            for (int j = 0; j < offs.length; j++) {
                if (costs[i]>=offs[j]) off = offs[j];


            }
            cost += costs[i] - off;

        }
        return cost;
    }

    private static int findOff(int cost, int[] offs,int current) {
        if (cost==offs[current]) return offs[current];
        if (cost > offs[current]) {
            if (current==offs.length-1) return offs[current];
            findOff(cost, offs, (current + offs.length) / 2);

        }
        if (cost < offs[current]) {
            if (current==0) return 0;

        }
        return 0;
    }
}
