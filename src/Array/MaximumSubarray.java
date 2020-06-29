package Array;

public class MaximumSubarray {

    private int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int k = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[k]) {
                k = i;
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(test));
    }
}
