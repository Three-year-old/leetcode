package Array;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return nums.length * (nums.length + 1) / 2 - total;
    }
}
