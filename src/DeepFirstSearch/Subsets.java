package DeepFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, new ArrayList<>());
        }
        res.add(new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list) {
        list.add(nums[start]);
        res.add(list);
        for (int i = start + 1; i < nums.length; i++) {
            dfs(nums, i, new ArrayList<>(list));
        }
    }
}
