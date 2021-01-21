package Tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToGreaterTree {

    private final List<Integer> list = new ArrayList<>();

    private int count = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        inorder(root);
        List<Integer> n = modify(list);
        change(root, n);
        return root;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) inorder(node.left);
        list.add(node.val);
        if (node.right != null) inorder(node.right);
    }

    private List<Integer> modify(List<Integer> l) {
        int total = 0;
        for (Integer integer : l) {
            total += integer;
        }
        List<Integer> res = new ArrayList<>();
        res.add(total);
        for (int i = 0; i < l.size() - 1; i++) {
            total -= l.get(i);
            res.add(total);
        }
        return res;
    }

    private void change(TreeNode node, List<Integer> m) {
        if (node == null) return;
        change(node.left, m);
        node.val = m.get(count);
        count++;
        change(node.right, m);
    }
}
