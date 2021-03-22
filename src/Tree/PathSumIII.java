package Tree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, map, sum);
        return count;
    }

    private void dfs(TreeNode node, int pre, Map<Integer, Integer> map, int target) {
        if (node == null) return;
        pre += node.val;
        if (map.containsKey(pre - target)) count += map.get(pre - target);
        map.put(pre, map.getOrDefault(pre, 0) + 1);
        dfs(node.left, pre, map, target);
        dfs(node.right, pre, map, target);
        map.put(pre, map.getOrDefault(pre, 0) - 1);
    }
}
