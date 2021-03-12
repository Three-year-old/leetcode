package Array;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) return;
        int large = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                large = i - 1;
                break;
            }
        }
        if (large == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int next = nums.length - 1;
        while (nums[next] <= nums[large]) {
            next--;
        }
        swap(nums, large, next);
        reverse(nums, large + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
