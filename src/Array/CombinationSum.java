package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, list);
        return res;
    }

    private void dfs(int[] candidates, int target, int position, List<Integer> path) {
        if (target <= 0) {
            if (target == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = position; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
