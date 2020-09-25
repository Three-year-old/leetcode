package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            stack.pop();
            res.add(peek.val);
            peek = peek.right;
            while (peek != null) {
                stack.push(peek);
                peek = peek.left;
            }
        }
        return res;
    }
}
