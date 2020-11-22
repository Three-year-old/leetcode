package Array;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int a = 0, b = 0, c = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < nums.length; k++) {
                    if (k == j || k == i) continue;
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                        a = i;
                        b = j;
                        c = k;
                        min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    }
                }
            }
        }
        return nums[a] + nums[b] + nums[c];
    }
}
