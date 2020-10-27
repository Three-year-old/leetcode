package LinkedList;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val < p.val) {
                ListNode tmp = p.next.next;
                if (p.next.val < head.val) {
                    p.next.next = head;
                    head = p.next;
                } else {
                    ListNode point = head;
                    while (point.next.val < p.next.val) {
                        point = point.next;
                    }
                    ListNode temp = point.next;
                    point.next = p.next;
                    point.next.next = temp;
                }
                p.next = tmp;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
