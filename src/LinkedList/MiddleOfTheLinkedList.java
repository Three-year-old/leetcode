package LinkedList;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                return slow.next;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
