package Array;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int i = 0, j = 0, iMin = 0, iMax = m, half = (m + n + 1) / 2;
        double maxLeft = 0, minRight;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = half - i;
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]) iMin = i + 1;
            else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) iMax = i - 1;
            else {
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                break;
            }
        }
        if ((m + n) % 2 == 1) return maxLeft;
        if (i == m) minRight = nums2[j];
        else if (j == n) minRight = nums1[i];
        else minRight = Math.min(nums1[i], nums2[j]);
        return (maxLeft + minRight) / 2;
    }
}
