package LinkedList;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p = res;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode start = p.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = p.next;
            p.next = then;
            then = start.next;
        }
        return res.next;
    }
}
