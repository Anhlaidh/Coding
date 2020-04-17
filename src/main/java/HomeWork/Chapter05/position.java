package HomeWork.Chapter05;

import HomeWork.entity.point;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/21 0021 20:15
 */
public class position extends point{

    public static int xInstance(point[] points) {
       if (points[0].x>points[1].x)return points[0].x-points[1].x;
       else return points[1].x-points[0].x;
    }

    public static point[] minPosition(point[] points) {
        if (points.length<=2) return points;
       else {
            point[] left = Arrays.copyOfRange(points, 0,points.length/2);
            point[] right;
            if (points.length%2==0) {
                right = Arrays.copyOfRange(points, points.length/2,points.length );
            }else right = Arrays.copyOfRange(points, points.length/2-1,points.length );
            left = minPosition(left);
            right = minPosition(right);
            if (xInstance(right)>xInstance(left)) return left;
            else return right;

        }


    }
    public static void main(String[] args) {
        point[] points = point.initPoint(10, 100);
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            System.out.print(points[i]+"\t");
        }
        System.out.println();
        point[] min = minPosition(points);
        for (int i = 0; i < min.length; i++) {
            System.out.print(min[i]+"\t");
        }

    }
}
