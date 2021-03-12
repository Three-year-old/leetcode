package DeepFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, visited, list, 0);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> list, int step) {
        if (step == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, step + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
