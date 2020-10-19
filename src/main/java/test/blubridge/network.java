package test.blubridge;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-16 21:37
 */
public class network {
    static class Set {
        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Node, HashSet<Node>> fathers = new HashMap<>();

        void put(int i, Node key) {
            map.put(i, key);
            HashSet<Node> children = new HashSet<>();
            children.add(key);
            fathers.put(key, children);
        }

        Node get(int key) {
            return map.get(key);
        }

        public void union(int aNode, int bNode) {
            Node a = map.get(aNode);
            Node b = map.get(bNode);
            Node aFather = a.findFather();
            Node bFather = b.findFather();
            if (aFather.equals(bFather)) {
                return;
            } else {
                bFather.head = aFather;
                HashSet<Node> aChildren = fathers.get(aFather);
                HashSet<Node> bChildren = fathers.get(bFather);
                aChildren.addAll(bChildren);


            }
        }

        public void send(int key, int weight) {
            Node node = map.get(key);
            Node father = node.findFather();
            HashSet<Node> nodes = fathers.get(father);
            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext()) {
                Node next = iterator.next();
                next.value += weight;
            }

        }
    }

    static class Node {
        int value;
        Node head;

        public Node() {
            head = this;
        }

        public Node findFather() {
            Node node = head;
            Stack<Node> stack = new Stack<>();
            while (node.head != node) {
                stack.push(node);
                node = node.head;

            }
            while (!stack.isEmpty()) {
                stack.pop().head = node;
            }
            return node;

        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        Set set = new Set();
        for (int i = 1; i <= n; i++) {
            set.put(i, new Node());
        }
        for (int i = 0; i < m; i++) {
            int opr = reader.nextInt();
            if (opr == 1) {
                int aNode = reader.nextInt();
                int bNode = reader.nextInt();
                set.union(aNode, bNode);
            }
            if (opr == 2) {
                int p = reader.nextInt();
                int t = reader.nextInt();
                set.send(p,t);
            }
        }
        for (int i = 1; i <= n; i++) {
            Node node = set.map.get(i);
            System.out.println(node.value);
        }
    }
}
