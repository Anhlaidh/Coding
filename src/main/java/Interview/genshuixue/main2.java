package Interview.genshuixue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-09 10:11
 */
public class main2 {

    public static class Node {

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    static Node getCommon(Node headA, Node headB) {
        HashSet<Node> set = new HashSet<>();
        Node cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;


    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        Node headA = null;
        Node headB = null;

        Map<String, Node> map = new HashMap<String, Node>();

        if (line1 != null && line1.length() > 0) {
            String[] array1 = line1.split(",");
            headA = new Node();
            headA.setData(Integer.parseInt(array1[0].split("\\(")[0]));
            map.put(array1[0], headA);
            Node pre = headA;
            for (int i = 1; i < array1.length; i++) {
                Node node = map.get(array1[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array1[i].split("\\(")[0]));
                    map.put(array1[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }
        if (line2 != null && line2.length() > 0) {
            String[] array2 = line2.split(",");
            headB = map.get(array2[0]);
            if (headB == null) {
                headB = new Node();
                headB.setData(Integer.parseInt(array2[0].split("\\(")[0]));
                map.put(array2[0], headB);
            }
            Node pre = headB;
            for (int i = 1; i < array2.length; i++) {
                Node node = map.get(array2[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array2[i].split("\\(")[0]));
                    map.put(array2[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }

        Node res = getCommon(headA, headB);
        System.out.println(res == null ? res : res.getData());
    }
}
