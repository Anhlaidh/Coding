package Interview.beisen;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-15 17:19
 */
public class binaryTree {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = e;
        b.left = d;
        e.left = f;
        binaryTree.print(root);
    }

    private static void print(Node root) {
        if (root==null) return;

        System.out.println(root.val);
        print(root.left);
        print(root.right);

    }
}
