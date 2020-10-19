package test;

import SwordFingerOffer.Inter;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-12 14:28
 */
public class cotains {
    public static void main(String[] args) {
        List<entry> list = new LinkedList<>();
        int[] ids = new int[]{1, 2, 3, 4, 5, 1};
        int[] scores = new int[]{1, 2, 3, 4, 5, 5};
        int top = 3;
        for (int i = 0; i < ids.length; i++) {
            entry e = new entry(ids[i], scores[i]);
            if (!list.contains(e)) {
                list.add(e);
            } else {
                list.get(list.indexOf(e)).scores += scores[i];
            }
        }
        Iterator<entry> iterator = list.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println();
        System.out.println();

        Collections.sort(list, new Comparator<entry>() {
            @Override
            public int compare(entry o1, entry o2) {
                return o2.scores - o1.scores;
            }
        });

        for (int i = 0; i < top; i++) {
            System.out.println(list.get(i));
        }


    }

    private static class entry {
        int id;
        int scores;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof entry) {
                return ((entry) obj).id == id;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "entry{" +
                    "id=" + id +
                    ", scores=" + scores +
                    '}';
        }

        public entry(int id, int scores) {
            this.id = id;
            this.scores = scores;
        }
    }
}
