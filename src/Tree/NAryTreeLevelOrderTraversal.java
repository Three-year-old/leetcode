package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                Node node = queue.poll();
                assert node != null;
                tmp.add(node.val);
                queue.addAll(node.children);
            }
            res.add(tmp);
        }
        return res;
    }
}
