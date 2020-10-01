package Interview.Left.graph;

import jdk.dynalink.NamedOperation;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-22 13:34
 */
public class myGraph {
    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 5},
                {},
                {3},
                {2},
                {},
                {3, 4},
                {0, 4}

        };
        Graph graph = getGraph(ints);
        printDFS(graph.nodes.get(6));

    }

    static void printBFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            set.add(cur);
            System.out.println(cur.val);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                }
            }
        }
    }

    static void printDFS(Node node) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    stack.push(cur);
                    stack.push(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }

    static class Node {
        public Node(int val) {
            this.val = val;
        }

        int val;
        List<Node> nexts = new ArrayList<>();
    }
    static class Edge{
        int in;
        int out;


        public Edge(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
    static class Graph{
        HashSet<Edge> edges = new HashSet<>();
        HashMap<Integer,Node> nodes = new HashMap<>();
    }

    static Graph getGraph(int[][] arr) {
        Graph graph = new Graph();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int out = arr[i][j];
                if (!graph.nodes.containsKey(i)) {
                    graph.nodes.put(i, new Node(i));
                }
                if (!graph.nodes.containsKey(out)) {
                    graph.nodes.put(out, new Node(out));
                }
                Edge edge = new Edge(i, out);
                graph.nodes.get(i).nexts.add(graph.nodes.get(out));
                graph.edges.add(edge);

            }
        }
        return graph;
    }
}
