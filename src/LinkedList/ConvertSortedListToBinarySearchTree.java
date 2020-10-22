package LinkedList;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = find(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) {
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode find(ListNode head) {
        ListNode p = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (p != null) {
            p.next = null;
        }
        return slow;
    }
}
