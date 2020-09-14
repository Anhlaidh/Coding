package test;


/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-08 10:46
 */
public class recover {

    public static void main(String[] args) {
        Node head = new Node(0);
        int N = 10;
        Node node = head;
        while (N-- > 0) {
            node.next = new Node(10 - N);
            node = node.next;
        }
        head = reCover(head);
        node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    private static Node reCover(Node head) {
        if (head==null) return null;
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
