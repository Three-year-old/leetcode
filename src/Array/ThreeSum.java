package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i], m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (nums[m] + nums[n] == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[m]);
                    tmp.add(nums[n]);
                    res.add(tmp);
                    while (m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    while (m < n && nums[n] == nums[n - 1]) {
                        n--;
                    }
                    m++;
                    n--;
                } else if (nums[m] + nums[n] > target) {
                    n--;
                } else {
                    m++;
                }
            }
        }
        return res;
    }
}
