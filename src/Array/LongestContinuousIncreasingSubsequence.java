package Array;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 1, max = 1;
        int[] copy = new int[nums.length + 1];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        copy[nums.length] = nums[nums.length - 1];
        for (int i = 0; i < copy.length; i++) {
            if (i + 1 < copy.length && copy[i] < copy[i + 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return max;
    }
}
