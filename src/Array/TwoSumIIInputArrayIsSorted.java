package Array;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    private int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        System.out.println(Arrays.toString(t.twoSum(test, 9)));
    }
}
