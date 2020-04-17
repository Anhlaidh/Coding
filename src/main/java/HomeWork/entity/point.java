package HomeWork.entity;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/21 0021 20:17
 */
public class point implements Comparable<point>{
    public int x;
    public int y;

    public point(int x, int y) {

    }

    public point() {

    }

    @Override
    public String toString() {
        return "point(" +
                x +
                ", " + y +
                ')';
    }


    public double distanceFrom(point point) {
        double length = Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y));
        return length;
    }
    public static point[] initPoint(int N, int size){
        point[] points = new point[N];
        for (int i=0;i<N;i++){
            points[i] = new point();
            points[i].x=(int)(Math.random()*size);
            points[i].y=(int)(Math.random()*size);
            for (int j=0;j<i;j++){
                if (points[i].x==points[j].x&&points[i].y==points[j].y){
                    i--;
                }
            }
        }
        return points;
    }



    @Override
    public int compareTo(point point) {
        return x-point.x;
    }
}