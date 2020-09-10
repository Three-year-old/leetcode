package Array;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        long first = nums[0], second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}
