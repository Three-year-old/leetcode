package Tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            }
            if (count % 2 == 0) {
                Collections.reverse(temp);
            }
            ans.add(temp);
            count++;
        }
        return ans;
    }
}
