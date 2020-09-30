package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class MaximumDepthOfNAryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node node = queue.poll();
                for (int j = 0; j < Objects.requireNonNull(node).children.size(); j++) {
                    queue.offer(node.children.get(j));
                }
            }
            depth++;
        }
        return depth;
    }
}
