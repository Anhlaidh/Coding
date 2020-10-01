package Interview.Left.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-19 15:55
 */
public class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
