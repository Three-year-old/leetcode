package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<TreeNode> pos = new ArrayList<>();
        preOrder(root, pos, pre);
        Collections.sort(pre);
        for (int i = 0; i < pre.size(); i++) {
            pos.get(i).val = pre.get(i);
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list, List<Integer> position) {
        if (root == null) {
            return;
        }
        preOrder(root.left, list, position);
        list.add(root);
        position.add(root.val);
        preOrder(root.right, list, position);
    }
}
