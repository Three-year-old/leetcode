package DynamicProgramming;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] left = new int[nums.length - 1];
        int[] right = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            left[i] = nums[i];
            right[i] = nums[i + 1];
        }
        int robLeft = new HouseRobber().rob(left);
        int robRight = new HouseRobber().rob(right);
        return Math.max(robLeft, robRight);
    }
}
