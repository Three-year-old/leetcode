package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(res, list, candidates, target - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
