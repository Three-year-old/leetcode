package LinkedList;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //令p指向头节点
        //p移动n步到r
        ListNode p = head;
        ListNode r = p;
        int k = n;
        while (k > 0) {
            r = p.next;
            if (r == null) {
                break;
            }
            p = p.next;
            k--;
        }
        if (k == 1) {
            return head.next;
        } else {
            p = head;
            if (r == null) {
                return null;
            }
            while (r.next != null) {
                p = p.next;
                r = r.next;
            }
            ListNode t = p.next;
            p.next = t.next;
            return head;
        }
    }
}
