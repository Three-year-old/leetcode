package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        List<Integer> order = new ArrayList<>();
        while (head != null) {
            order.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < order.size() / 2; i++) {
            if (!order.get(i).equals(order.get(order.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
