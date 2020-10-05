package LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode r = p;
        int carry = 0;
        while (l1 != null && l2 != null) {
            p.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while (l1 != null) {
            p.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            p = p.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return r.next;
    }
}
