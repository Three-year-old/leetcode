package Array;

import java.util.Arrays;

public class MergeSortedArray {

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
        }
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeSortedArray m = new MergeSortedArray();
        m.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
