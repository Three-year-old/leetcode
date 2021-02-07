package DynamicProgramming;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int volume = 0;
        for (int num : nums) {
            volume += num;
        }
        if (volume % 2 != 0) return false;
        volume /= 2;
        boolean[] dp = new boolean[volume + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = volume; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[volume];
    }
}
