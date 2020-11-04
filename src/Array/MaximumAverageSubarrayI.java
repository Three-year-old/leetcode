package Array;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += nums[i];
        }
        int max = res;
        for (int i = k; i < nums.length; i++) {
            res = res + nums[i] - nums[i - k];
            max = Math.max(max, res);
        }
        return max * 1.0 / k;
    }
}
