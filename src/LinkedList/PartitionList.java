package LinkedList;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode g = head;
        ListNode l = head;
        while (g != null && g.val < x) {
            g = g.next;
        }
        while (l != null && l.val >= x) {
            l = l.next;
        }
        if (l == null || g == null) {
            return head;
        }
        ListNode l_ = l;
        ListNode g_ = g;
        ListNode p = head.next;
        while (p != null) {
            if (p != l && p != g) {
                if (p.val < x) {
                    l_.next = p;
                    l_ = l_.next;
                } else {
                    g_.next = p;
                    g_ = g_.next;
                }
            }
            p = p.next;
        }
        l_.next = g;
        g_.next = null;
        return l;
    }
}
