package SwordFingerOffer;

import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-12 23:00
 */
public class recLinked {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();
        if (listNode==null) return list;
        ArrayAdd(list, listNode);
        return list;

    }

    private void ArrayAdd(ArrayList list, ListNode listNode) {
        if (listNode.next == null) {
            list.add(listNode.val);
            return;
        }

        ArrayAdd(list, listNode.next);
        list.add(listNode.val);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}