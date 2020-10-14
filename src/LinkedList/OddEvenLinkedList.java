package LinkedList;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode odd = p;
        ListNode q = head.next;
        ListNode even = q;
        while (true) {
            if (odd == p && even == q) {
                if (q == null) {
                    break;
                }
                p = q.next;
                if (p == null) {
                    break;
                }
                q = p.next;
            } else {
                ListNode tmp = odd.next;
                odd.next = p;
                even.next = q;
                p.next = tmp;
                odd = p;
                even = q;
            }
        }
        return head;
    }
}
