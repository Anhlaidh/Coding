package Interview.Left.graph;

import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-19 15:55
 */
public class Node {
    int val;
    int in;
    int out;
    ArrayList<Edge> edges;
    ArrayList<Node> nexts;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        edges = new ArrayList<>();
        nexts = new ArrayList<>();

    }
}
