package LinkedList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (head == null) {
            return true;
        }
        if (head.val == root.val) {
            return check(head.next, root.left) || check(head.next, root.right) || isSubPath(head, root.left) || isSubPath(head, root.right);
        } else {
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }

    private boolean check(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val == root.val) {
            return check(head.next, root.right) || check(head.next, root.left);
        }
        return false;
    }
}
