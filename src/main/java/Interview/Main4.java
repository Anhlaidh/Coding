package Interview;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-12 20:26
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        while (N-- > 0) {
            int size = reader.nextInt();
            int[] builds = new int[size];
            for (int i = 0; i < builds.length; i++) {
                builds[i] = reader.nextInt();
            }
            for (int i = 0; i < builds.length; i++) {


                System.out.print(solution(builds,i,0)+" ");
            }
            System.out.println();
        }
    }

    private static int solution(int[] builds, int i,int vector) {
        if (i==0||i==builds.length-1) return 0;
        if (builds[i]>=builds[i-1]) return 1;
        if (builds[i]<builds[i-1]&&vector==-1) return 0;
        if (builds[i]>=builds[i+1]) return 1;
        if (builds[i]<builds[i+1]&&vector==1) return 0;
        if (vector==-1) return solution(builds, i - 1, vector);
        if (vector==1) return solution(builds, i + 1, vector);
         return solution(builds, i-1, -1)+solution(builds, i+1, 1);


    }
}
