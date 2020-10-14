package LinkedList;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        ListNode p = head;
        ListNode q = p.next;
        while (true) {
            if (q == null) {
                break;
            }
            ListNode tmp = q.next;
            q.next = p;
            p.next = tmp;
            res.next = q;
            res = p;
            if (p.next == null) {
                break;
            }
            p = p.next;
            q = p.next;
        }
        return ans.next;
    }
}
