package Array;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int i : nums)
            max = Math.max(max, i);
        int[] count = new int[max + 1];
        int[] left = new int[max + 1];
        int[] right = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 0)
                left[nums[i]] = i;
            right[nums[i]] = i;
            count[nums[i]]++;
        }
        int degree = 0;
        int min = Integer.MAX_VALUE;
        for (int j : count) {
            if (j >= degree) {
                degree = j;
            }
        }
        for (int x = 0; x < count.length; x++) {
            if (count[x] == degree) {
                min = Math.min(min, right[x] - left[x] + 1);
            }
        }
        return min;
    }
}
