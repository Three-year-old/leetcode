package Tree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(depth(treeNode.left), depth(treeNode.right)) + 1;
    }
}
