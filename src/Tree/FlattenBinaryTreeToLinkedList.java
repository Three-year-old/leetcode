package Tree;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        if (root.left == null) {
            return;
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            TreeNode tmp = root.right;
            root.right = root.left;
            right(root.right).right = tmp;
            root.left = null;
        }
    }

    private TreeNode right(TreeNode tree) {
        if (tree == null) return null;
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }
}
