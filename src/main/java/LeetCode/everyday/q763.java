package LeetCode.everyday;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-22 10:19
 */
public class q763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    public static List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        Area[] areas = new Area[26];
        for (int i = 0; i < chars.length; i++) {
            if (areas[chars[i] - 'a'] == null) {
                areas[chars[i] - 'a'] = new Area(i, i);
            } else {
                areas[chars[i] - 'a'].end = i;
            }
        }
        //去重集合
        for (int i = 0; i < areas.length; i++) {
            if (areas[i] == null) continue;

            for (int j = 0; j < areas.length; j++) {

                if (areas[j] == null) continue;
                //j是否为子集
                if (areas[i].start < areas[j].start && areas[i].end > areas[j].end) {
                    areas[j].start = areas[i].start;
                    areas[j].end = areas[i].end;
                } else if (i < j) {
                    if (areas[i].start < areas[j].start && areas[j].start > areas[i].end && areas[i].end > areas[j].end) {
                        areas[j].start = areas[i].start;
                        areas[i].end = areas[j].end;
                    } else if (areas[i].start < areas[j].start && areas[j].start < areas[j].end && areas[j].end < areas[i].end) {
                        areas[j].start = areas[i].start;
                        areas[j].end = areas[i].end;
                    }
                } else if (j < i) {
                    if (areas[j].start < areas[i].start && areas[i].start > areas[j].end && areas[j].end > areas[i].end) {
                        areas[i].start = areas[j].start;
                        areas[j].end = areas[i].end;
                    }
                    else if (areas[j].start < areas[i].start && areas[i].start < areas[i].end && areas[i].end < areas[j].end) {
                        areas[i].start = areas[j].start;
                        areas[i].end = areas[j].end;
                    }
                }

            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (Area area : areas) {
            if (area == null) continue;
            set.add(area.end);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
//        list.remove(list.size() - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i > 0) {
                list.set(i, list.get(i) - list.get(i - 1));
            } else {
                list.set(i, list.get(i) + 1);
            }
        }

        return list;


    }

    private static class Area {
        int start;
        int end;

        public Area(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
