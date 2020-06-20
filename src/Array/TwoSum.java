package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (mp.get(nums[i]) == null) {
                mp.put(tmp, i);
            } else {
                res[0] = mp.get(nums[i]);
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        int target = 9;
        TwoSum t = new TwoSum();
        int[] res = t.twoSum(test, target);
        System.out.println(Arrays.toString(res));
    }
}
