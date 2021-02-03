package Tree;

public class DiameterOfBinaryTree {

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        int dfs = dfs(root);
        return res - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
