package DeepFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(2 * n, 0, 0, "");
        return res;
    }

    private void dfs(int length, int left, int right, String path) {
        if (left + right > length || left > length / 2 || right > length / 2) return;
        if (left + right == length) {
            res.add(path);
            return;
        }
        dfs(length, left + 1, right, path + "(");
        if (left > right) {
            dfs(length, left, right + 1, path + ")");
        }
    }
}
