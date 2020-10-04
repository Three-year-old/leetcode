package Array;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int l = 0, r = 0;
                while (mid - l >= 0 && nums[mid - l] == target) {
                    l++;
                }
                while (mid + r < nums.length && nums[mid + r] == target) {
                    r++;
                }
                res[0] = mid - l + 1;
                res[1] = mid + r - 1;
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static void main(String[] args) {
//        int[] test = {5, 7, 7, 8, 8, 10};
        int[] test = {1};
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(f.searchRange(test, 1)));
    }
}
