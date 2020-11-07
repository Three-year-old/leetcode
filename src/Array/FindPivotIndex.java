package Array;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count * 2 == sum - nums[i]) {
                return i;
            } else {
                count += nums[i];
            }
        }
        return -1;
    }
}
