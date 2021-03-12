package Array;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int l = leftSearch(nums, left, right, target);
        int r = rightSearch(nums, left, right, target);
        if (l > r) return new int[]{-1, -1};
        return new int[]{l, r};
    }

    private int rightSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int leftSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
