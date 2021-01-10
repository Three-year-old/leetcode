package Array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int offset = nums[0];
        int start = nums[0];
        int end;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + offset) {
                offset = nums[i] - i;
                end = nums[i - 1];
                if (start != end) ans.add(start + "->" + end);
                else ans.add(String.valueOf(start));
                start = nums[i];
            }
        }
        if (start != nums[nums.length - 1]) {
            ans.add(start + "->" + nums[nums.length - 1]);
        } else {
            ans.add(String.valueOf(start));
        }
        return ans;
    }
}
