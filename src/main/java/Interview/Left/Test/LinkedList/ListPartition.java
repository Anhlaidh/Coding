package Interview.Left.Test.LinkedList;

import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-08 13:34
 */
public class ListPartition {
    public static void main(String[] args) {
        Node head = new Node(4);
        int N = 10;
        Node node = head;
        Random random = new Random();
        while (N-- > 0) {
            node.next = new Node(random.nextInt(10));
            node = node.next;
        }
        node = head;
        int pivot = head.val;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        Node partition = partition(head, pivot);
        System.out.println();
        node = partition;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }

    }

    private static Node partition(Node head, int pivot) {
        //小于区头尾
        Node sH = null;
        Node sT = null;
        //等于区头尾
        Node eH = null;
        Node eT = null;
        //大于区头尾
        Node lH = null;
        Node lT = null;
        Node node = head;
        while (node != null) {
            //小于区
            if (node.val < pivot) {
                if (sH == null) {
                    sH = node;
                    sT = node;
                    node = node.next;
                    //断开当前节点
                    sH.next = null;
                } else {
                    sT.next = node;
                    sT = sT.next;
                    node = node.next;
                    sT.next = null;
                }
                //等于区
            } else if (node.val == pivot) {
                if (eH == null) {
                    eH = node;
                    eT = node;
                    node = node.next;
                    eH.next = null;
                } else {
                    eT.next = node;
                    eT = eT.next;
                    node = node.next;
                    eT.next = null;
                }

                //大于区
            } else if (node.val > pivot) {
                if (lH == null) {
                    lH = node;
                    lT = node;
                    node = node.next;
                    lH.next = null;
                } else {
                    lT.next = node;
                    lT = lT.next;
                    node = node.next;
                    lT.next = null;
                }

            }
        }
        //连接三段
        if (sT != null) {
            sT.next = eH;
            if (eT != null) {
                eT.next = lT;
            }
        }
        if (eT != null) {
            eT.next = lH;
        }

        return sH != null ? sH : (eH != null ? eH : lH);
    }

}
