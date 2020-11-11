package Array;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            if (i != 0 && nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i <= 0) {
            Arrays.sort(nums);
            return;
        }
        int j;
        for (j = nums.length; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                break;
            }
        }
        int temp = nums[j];
        nums[j] = nums[i - 1];
        nums[i - 1] = temp;
        Arrays.sort(nums, i, nums.length);
    }
}
