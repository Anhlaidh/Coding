package Interview.bianlifeng;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-09 18:25
 */
public class main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Stack<area> stack = new Stack<>();
        List<area> areas = new ArrayList<>();
        String s = reader.nextLine();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] date = split[i].split("-");
            int left = Integer.parseInt(date[0]);
            int right = Integer.parseInt(date[1]);
            areas.add(new area(left,right));
        }
        Collections.sort(areas, new Comparator<area>() {
            @Override
            public int compare(area o1, area o2) {
                return o2.left - o1.left;
            }
        });
        for (int i = 0; i < areas.size(); i++) {
            stack.push(areas.get(i));
        }
        List<area> result = new ArrayList<>();
        area temp = null;
        if (!stack.isEmpty()) {
            temp = stack.pop();
        }
        while (!stack.isEmpty()) {
            area cur = stack.pop();
            if (temp.right >= cur.left-1) {
                temp = merge(temp, cur);
            } else {
                result.add(temp);
                stack.push(cur);
                if (stack.isEmpty()) {
                    break;
                }
                temp = stack.pop();
            }

        }
        result.add(temp);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i<result.size()-1) System.out.print(",");
        }

    }

    private static area merge(area a, area b) {
        return new area(a.left, b.right);
    }

    static class area{
        int left;
        int right;

        public area(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return left + "-" + right;
        }
    }
}
