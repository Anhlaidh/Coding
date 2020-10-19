package LeetCode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-15 20:17
 */
public class q116 {
    public static Node connect(Node root) {
        if (root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int n = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                break;
            }
            boolean flag = false;
            n++;
            int t =1;
            int temp = 0;
            while (t < n) {
                t = (int) Math.pow(2,temp);
                if (t == n+1) {
                    flag = true;
                    break;
                }
                temp++;
            }
            node.next = flag ? null : queue.peek();


            queue.add(node.left);
            queue.add(node.right);

        }
        root.next = null;
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    }


    public static void main(String[] args) {
        Node node_1 = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        Node node_5 = new Node(5);
        Node node_6 = new Node(6);
        Node node_7 = new Node(7);
        Node node_8 = new Node(8);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;
        node_4.left = node_8;
        connect(node_1);
        System.out.println("1");

    }
}
