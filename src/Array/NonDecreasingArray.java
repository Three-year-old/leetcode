package Array;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int p = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                p = i + 1;
                count++;
            }
        }
        if (p == 0) {
            return true;
        }
        if (count > 1) {
            return false;
        }
        int right = Integer.MAX_VALUE, left = Integer.MIN_VALUE;
        if (p + 1 < nums.length) {
            right = nums[p + 1];
        }
        if (p - 2 >= 0) {
            left = nums[p - 2];
        }
        return Math.max(nums[p], nums[p - 1]) <= right && Math.max(nums[p], nums[p - 1]) >= left || Math.min(nums[p], nums[p - 1]) <= right && Math.min(nums[p], nums[p - 1]) >= left;
    }
}
