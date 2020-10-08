package LinkedList;

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        ListNode p = reverse(head);
        int pow = 0;
        int res = 0;
        while (p != null) {
            res += (p.val * Math.pow(2, pow));
            p = p.next;
            pow++;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
