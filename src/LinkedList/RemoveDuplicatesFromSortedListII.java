package LinkedList;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = fake;
        ListNode q = head;
        while (q != null) {
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (p.next != q) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        return fake.next;
    }
}
