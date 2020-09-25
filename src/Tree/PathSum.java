package Tree;

public class PathSum {

    private boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            DPS(root, sum);
            return flag;
        }
    }

    private void DPS(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                flag = true;
            }
        } else if (root.left != null && root.right == null) {
            DPS(root.left, sum - root.val);
        } else if (root.left == null) {
            DPS(root.right, sum - root.val);
        } else {
            DPS(root.left, sum - root.val);
            DPS(root.right, sum - root.val);
        }
    }
}
