package LinkedList;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        k = k % length;
        while (k > 0) {
            ListNode p = head;
            ListNode q = null;
            while (p.next != null) {
                q = p;
                p = p.next;
            }
            p.next = head;
            if (q != null) {
                q.next = null;
            } else {
                head.next = null;
            }
            head = p;
            k--;
        }
        return head;
    }
}
