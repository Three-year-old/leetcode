package Array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            uf.merge(num, num + 1);
        }
        int max = 1;
        for (int num : nums) {
            Integer find = uf.find(num);
            assert find != null;
            max = Math.max(max, find - num + 1);
        }
        return max;
    }

    static class UnionFind {
        private final Map<Integer, Integer> map;

        public UnionFind(int[] p) {
            map = new HashMap<>();
            for (int i : p) {
                map.put(i, i);
            }
        }

        private Integer find(int k) {
            if (!map.containsKey(k)) return null;
            int root = k;
            while (root != map.get(root)) {
                root = map.get(root);
            }
            return root;
        }

        private void merge(int x, int y) {
            Integer p = find(x);
            Integer q = find(y);
            if (p == null || q == null) return;
            if (p.equals(q)) return;
            map.put(p, q);
        }
    }
}
