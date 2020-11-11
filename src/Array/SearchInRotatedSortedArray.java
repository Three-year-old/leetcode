package Array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        int rotate = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int real = (mid + rotate) % nums.length;
            if (nums[real] > target) high = mid - 1;
            else if (nums[real] < target) low = mid + 1;
            else return real;
        }
        return -1;
    }
}
