package LinkedList;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            if (map.get(p.val) == null) {
                map.put(p.val, 1);
            } else {
                map.put(p.val, map.get(p.val) + 1);
            }
            p = p.next;
        }
        ListNode res = new ListNode(-1);
        ListNode q = res;
        p = head;
        while (p != null) {
            if (map.get(p.val) == 1) {
                q.next = new ListNode(p.val);
                q = q.next;
            }
            p = p.next;
        }
        return res.next;
    }
}
