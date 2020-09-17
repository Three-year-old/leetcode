package Array;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    private int longestSubarray(int[] nums) {
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int k = 0;
                while (i + k + 1 < nums.length && nums[i + k + 1] == 1) {
                    k++;
                }
                if (max < count + k) {
                    max = count + k;
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (count == nums.length) {
            return count - 1;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] test = {0, 0, 0};
//        int[] test = {1, 1, 0, 0, 1, 1, 1, 0, 1};
//        int[] test = {1, 1, 1};
//        int[] test = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int[] test = {1, 1, 0, 1};
        LongestSubarrayOf1sAfterDeletingOneElement l = new LongestSubarrayOf1sAfterDeletingOneElement();
        System.out.println(l.longestSubarray(test));
    }
}
