package LeetCode.day1.q2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: LeetCode
 * @author: Anhlaidh
 * @date: 2020/1/20 0020 14:23
 */
/**
 * Definition for singly-linked list.
 **/


public class TwoNumberAdd {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        //设置头指针（理解）

        int carry = 0;
        while (l1!=null||l2!=null||carry!=0){//carry!=0判断条件卡 5 5
            ListNode cur=new ListNode(0);
            int sum = ((l1==null)?0:l1.val)+((l2==null)?0:l2.val)+carry;
            carry=sum/10;
            int val = sum%10;
            cur.val=val;
            prev.next=cur;
            prev=cur;
            //指针的应用


            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
            //切换指针位置
        }

        return  head.next;
    }
}
