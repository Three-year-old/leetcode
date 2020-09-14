package Array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        } else if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[1] == target) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return binAndRecursion(nums, target, 0, nums.length - 1);
        }
    }

    private int binAndRecursion(int[] nums, int target, int start, int end) {
        // 二分查找
        // 如果二分中点大/小于左右
        // 那么左右都是单调增序列
        // 否则就判断与左右端点大小
        // 比左右端点都大说明左边增序列右边递归
        // 反之亦然
        if (start >= end) {
            return nums[end] == target ? end : -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if ((nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) || (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1])) {
            // 此时二分点为极点
            // 左右都是递增序列
            // 左边二分查找
            int leftSideStart = start, leftSideEnd = mid;
            // 右边二分查找
            int rightSideStart = mid, rightSideEnd = end;
            int l = binSearch(nums, target, leftSideStart, leftSideEnd - 1);
            int r = binSearch(nums, target, rightSideStart + 1, rightSideEnd);
            if (l != -1) {
                return l;
            }
            return r;
        } else if (nums[mid] > nums[start]) {
            // 左边增序列右边递归
            int left = start, right = mid;
            if (target <= nums[right] && target >= nums[left]) {
                // 如果在左边序列中
                return binSearch(nums, target, left, right);
            } else {
                return binAndRecursion(nums, target, right, end);
            }
        } else {
            // 右边增序列左边递归
            int left = mid, right = end;
            if (target <= nums[right] && target >= nums[left]) {
                // 如果在左边序列中
                return binSearch(nums, target, left, right);
            } else {
                return binAndRecursion(nums, target, start, left);
            }
        }
    }

    private int binSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] test = {5, 1, 2, 3, 4};
        System.out.println(s.search(test, 1));
    }
}
