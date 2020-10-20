package LinkedList;

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        int sum = 0;
        while (p != null) {
            sum += p.val;
            map.put(sum, p);
            p = p.next;
        }
        p = head;
        sum = 0;
        while (p != null) {
            sum += p.val;
            ListNode node = map.get(sum);
            if (sum == 0) {
                head = node.next;
            }
            if (node != p) {
                p.next = node.next;
            }
            p = p.next;
        }
        return head;
    }
}
