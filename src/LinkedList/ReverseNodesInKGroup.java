package LinkedList;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int step = 0;
        ListNode p = head;
        while (p != null && step != k) {
            p = p.next;
            step++;
        }
        if (step == k) {
            p = reverseKGroup(p, k);
            while (step-- > 0) {
                ListNode tmp = head.next;
                head.next = p;
                p = head;
                head = tmp;
            }
            head = p;
        }
        return head;
    }
}
