package Tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left) && (root1.val == root2.val);
    }
}
