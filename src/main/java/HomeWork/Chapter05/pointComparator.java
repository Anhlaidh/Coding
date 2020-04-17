package HomeWork.Chapter05;

import HomeWork.entity.point;

import java.util.Comparator;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/22 0022 10:59
 */
public class pointComparator implements Comparator<point> {
    @Override
    public int compare(point point, point t1) {
        return point.x-t1.x;
    }
}
