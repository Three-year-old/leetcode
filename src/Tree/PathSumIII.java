package Tree;

public class PathSumIII {

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root, sum, 0);
        fuck(root.left, root.right, sum);
        return count;
    }

    private void fuck(TreeNode left, TreeNode right, int sum) {
        dfs(left, sum, 0);
        dfs(right, sum, 0);
        if (left != null) fuck(left.left, left.right, sum);
        if (right != null) fuck(right.left, right.right, sum);
    }

    private void dfs(TreeNode root, int sum, int path) {
        if (root == null) return;
        path += root.val;
        if (path == sum) count++;
        int copy = path;
        dfs(root.left, sum, path);
        dfs(root.right, sum, copy);
    }
}
