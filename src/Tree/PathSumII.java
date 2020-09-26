package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            search(root, sum, path);
        }
        return res;
    }

    private void search(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(list);
            }
        } else if (root.left != null && root.right == null) {
            List<Integer> left = new ArrayList<>(list);
            search(root.left, sum - root.val, left);
        } else if (root.left == null) {
            List<Integer> right = new ArrayList<>(list);
            search(root.right, sum - root.val, right);
        } else {
            List<Integer> left = new ArrayList<>(list);
            search(root.left, sum - root.val, left);
            List<Integer> right = new ArrayList<>(list);
            search(root.right, sum - root.val, right);
        }
    }
}
