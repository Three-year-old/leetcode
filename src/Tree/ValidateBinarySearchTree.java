package Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    private boolean flag = true;

    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        check(root);
        inOrder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return flag;
    }

    private void check(TreeNode tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            if (tree.val <= tree.left.val) {
                flag = false;
            }
            check(tree.left);
        }
        if (tree.right != null) {
            if (tree.val >= tree.right.val) {
                flag = false;
            }
            check(tree.right);
        }
    }

    private void inOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        list.add(tree.val);
        inOrder(tree.right);
    }
}
