package Array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        String str = String.valueOf(nums[0]);
        int p = 0;
        while (p < nums.length) {
            if (p + 1 < nums.length && nums[p + 1] - nums[p] != 1) {
                if (p == 0) {
                    ans.add(String.valueOf(nums[0]));
                } else {
                    if (String.valueOf(nums[p]).equals(str)) {
                        ans.add(str);
                    } else {
                        ans.add(str.concat("->" + nums[p]));
                    }
                }
                str = String.valueOf(nums[p + 1]);
            }
            p++;
        }
        if (str.equals(String.valueOf(nums[nums.length - 1]))) {
            ans.add(str);
        } else if (str.equals(String.valueOf(nums[0]))) {
            if (ans.size() == 1) {
                ans.add(String.valueOf(nums[0]));
            } else {
                ans.add(nums[0] + "->" + nums[nums.length - 1]);
            }
        } else {
            ans.add(str + "->" + nums[nums.length - 1]);
        }
        return ans;
    }
}
