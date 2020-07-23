package Array;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0);
        ListNode p = r;
        int flag = 0;
        while (l1 != null && l2 != null) {
            r.next = new ListNode((l1.val + l2.val + flag) % 10);
            flag = (l1.val + l2.val + flag) / 10;
            l1 = l1.next;
            l2 = l2.next;
            r = r.next;
        }
        while (l1 != null) {
            r.next = new ListNode((l1.val + flag) % 10);
            flag = (l1.val + flag) / 10;
            r = r.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            r.next = new ListNode((l2.val + flag) % 10);
            flag = (l2.val + flag) / 10;
            r = r.next;
            l2 = l2.next;
        }
        if (flag == 1) {
            r.next = new ListNode(1);
        }
        return p.next;
    }
}

