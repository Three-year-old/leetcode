package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1 1 2 5 6 7 10
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, list);
        return res;
    }

    private void dfs(int[] candidates, int target, int position, List<Integer> path) {
        if (target <= 0) {
            if (target == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = position; i < candidates.length; i++) {
            if (i > position && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
