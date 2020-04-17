package HomeWork.Chapter02;

import HomeWork.TimeTool.TimeTool;
import HomeWork.entity.point;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/2/28 0028 19:40
 */
public class position {



//    static boolean[][] randomMap(int N,int size){
//        boolean[][] map = new boolean[size][size];
//        for (int i =0;i<N;i++){
//            int x=(int)(Math.random()*size);
//            int y=(int)(Math.random()*size);
//            if (map[x][y]) i--;
//            else map[x][y]=true;
//        }
//        return map;
//    }
    static void show(boolean[][] map){
        for (int i = 0;i<map.length;i++){
            for (int j =0;j<map[i].length;j++){
                if (!map[i][j]) System.out.print("-");
                else System.out.print("o");
            }
            System.out.println();
        }
    }
    point[] point(int N, int size){
        point[] points = new point[N];
        for (int i=0;i<N;i++){
            points[i] = new point();
            points[i].x=(int)(Math.random()*size);
            points[i].y=(int)(Math.random()*size);
        }
        return points;
    }
    void shortest(point[] points){
        double distance_min = points.length*points.length;
        point point_A = new point();
        point point_B = new point();
        for (int i=0;i<points.length;i++){
            for (int j=i;j<points.length;j++){
                if (i==j) continue;
                if (points[i].distanceFrom(points[j])<distance_min){
                    distance_min = points[i].distanceFrom(points[j]);
                   point_A = points[i];
                   point_B = points[j];
                }

            }
        }
        System.out.println("A point:"+point_A);
        System.out.println("B_point:"+point_B);
        System.out.println("distance="+point_A.distanceFrom(point_B));
    }
    public static void main(String[] args) {
        position position = new position();
        point[] points =  position.point(10,100);

        for (int i=0;i<points.length;i++){
           System.out.print(i+1+":");
           System.out.println(points[i]);
        }
        TimeTool.check("check", new TimeTool.Task() {
            @Override
            public void execute() {
                position.shortest(points);
            }
        });

    }
}
