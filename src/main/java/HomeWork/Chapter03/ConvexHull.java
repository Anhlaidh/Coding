package HomeWork.Chapter03;

import HomeWork.TimeTool.TimeTool;
import HomeWork.entity.point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/6 0006 15:07
 */
public class ConvexHull extends position {
    class Vector{
        point start;
        point end;
        double a;
        double b;
        double c;

        Vector(point start, point end) {
            this.start = start;
            this.end = end;
            a = end.y-start.y;
            b = start.x-end.x;
            c = (start.x*end.y)-(end.x*start.y);
        }
    }

     List<Vector> solution(point[] points){
        List<Vector> result = new LinkedList<>();
        for (int i =0;i<points.length;i++){
            for (int j=i+1;j<points.length;j++){
                Vector vector = new Vector(points[i],points[j]);
                List<Character> container = new ArrayList<>();
                for (int k = 0;k<points.length;k++){
                    if (k==i||k==j) continue;
                    double v = (points[k].x * vector.a) + (vector.b * points[k].y);
                    if (v <vector.c) container.add('-');
                    else if (v>vector.c) container.add('+');
                    else container.add(' ');
                }
                if ((container.contains('+')&&container.contains('-')))  continue;
                   else {
                    result.add(new Vector(points[i],points[j]));
                }
            }
        }
        return result;

    }
    public List<Vector> sort(List<Vector> vectors){
        List<Vector> vectorList = new LinkedList<>();
        vectorList.add(vectors.get(0));
        vectors.remove(0);
        int current=0;
        int i=1;
        while (vectors.size()!=0){
            if (i>vectors.size()-1) i=0;

            if (vectorList.get(current).end.equals(vectors.get(i).start)){
                vectorList.add(vectors.get(i));
                vectors.remove(i);
                current++;
            }else if (vectorList.get(current).end.equals(vectors.get(i).end)){
                point point_a = new point(vectors.get(i).start.x,vectors.get(i).start.y);
                point point_b = new point(vectors.get(i).end.x,vectors.get(i).end.y);
                Vector vector = new Vector(point_b,point_a);
                vectorList.add(vector);
                vectors.remove(i);
                current++;
            }
            i++;
        }
        return vectorList;
    }
    public static void main(String[] args) {
        ConvexHull position = new ConvexHull();
        point[] points =point.initPoint(20, 100);
//                ={new point(8,7),new point(7,2),new point(7,6),new point(4,2),new point(6,1)};


        System.out.println("随机样例：");
        for (point point : points) {
            System.out.print(point + "\t");
        }
        System.out.println();
//        for (Vector vector : list) {
//            System.out.print(vector.start + "->" + vector.end);
//        }
        TimeTool.check("凸包问题", new TimeTool.Task() {
            @Override
            public void execute() {
                List<Vector> list = position.solution(points);
                System.out.println("边数"+list.size());
                List<Vector> sort = position.sort(list);
                System.out.println();
                for (int i=0;i<sort.size();i++) {

                    if (!(i==sort.size()-1)) System.out.print(sort.get(i).start + "->");
                    else System.out.println(sort.get(i).start);
                }
            }
        });

    }
}
