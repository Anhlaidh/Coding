package exam.exam1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class trPoint {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        point[] points = new point[N];

        for (int i = 0; i < N; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            point point = new point(x, y);
            points[i] = point;
        }
        List<point> result = new ArrayList<>();
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            boolean flag = true;
            for (int j = i; j < points.length; j++) {
                if (points[i].y < points[j].y) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(points[i]);
        }
        for (int i = 0; i < result.size() ;i++) {
            point p = result.get(i);
            System.out.println(p.x + " " + p.y);

        }


    }
    static class point implements Comparable<point>{
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(point o) {
            return x - o.x;
        }
    }



}
