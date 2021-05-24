package Tree;

public class BinaryTreeMaximumPathSum {

    int temp = -1001;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return temp;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        if (left + right + root.val > temp) temp = left + root.val + right;
        return root.val + Math.max(left, right);
    }
}
