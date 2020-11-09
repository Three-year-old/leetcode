package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.size() == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(interval[0]);
                temp.add(interval[1]);
                res.add(temp);
            } else {
                boolean flag = false;
                for (List<Integer> re : res) {
                    if (interval[0] >= re.get(0) && interval[0] <= re.get(1)) {
                        re.set(1, Math.max(re.get(1), interval[1]));
                        flag = true;
                        break;
                    }
                    if (interval[1] >= re.get(0) && interval[1] <= re.get(1)) {
                        re.set(0, Math.min(re.get(0), interval[0]));
                        flag = true;
                        break;
                    }
                    if (interval[0] <= re.get(0) && interval[1] >= re.get(1)) {
                        re.set(0, interval[0]);
                        re.set(1, interval[1]);
                        flag = true;
                        break;
                    }
                    if (interval[0] >= re.get(0) && interval[1] <= re.get(1)) {
                        re.set(0, interval[0]);
                        re.set(1, interval[1]);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(interval[0]);
                    temp.add(interval[1]);
                    res.add(temp);
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        return ans;
    }
}
