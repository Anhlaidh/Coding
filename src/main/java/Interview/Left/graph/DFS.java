
package Interview.Left.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-19 16:10
 */
public class DFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> nodes = new HashSet<>();
        stack.push(node);
        nodes.add(node);
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!nodes.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    nodes.add(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }

}
