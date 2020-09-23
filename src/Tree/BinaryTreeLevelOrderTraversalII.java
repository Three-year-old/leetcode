package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                assert poll != null;
                tmp.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans.add(tmp);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            res.add(ans.get(ans.size() - 1 - i));
        }
        return res;
    }
}
