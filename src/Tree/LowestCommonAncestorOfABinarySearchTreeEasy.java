package Tree;

public class LowestCommonAncestorOfABinarySearchTreeEasy {

    private TreeNode res = new TreeNode(-1);

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        function(root, p, q);
        return res;
    }

    private void function(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if (root.val >= p.val && root.val <= q.val) {
            res = root;
            return;
        }
        lowestCommonAncestor(root.right, p, q);
        lowestCommonAncestor(root.left, p, q);
    }
}
