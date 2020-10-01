package Interview.Left.graph;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-19 15:56
 */
public class Edge {
    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
