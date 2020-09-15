package Array;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int j : A) {
            sum += j;
        }
        if (sum % 3 != 0) {
            return false;
        } else {
            int left = 0, right = A.length - 1;
            int part = sum / 3;
            int l = Integer.MIN_VALUE, m = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
            while ((l != part || m != part || r != part) && right > left) {
                while (l != part) {
                    if (left > A.length - 1) {
                        return false;
                    }
                    l = 0;
                    for (int i = 0; i <= left; i++) {
                        l += A[i];
                    }
                    left++;
                }
                while (r != part) {
                    if (right < 0) {
                        return false;
                    }
                    r = 0;
                    for (int i = right; i < A.length; i++) {
                        r += A[i];
                    }
                    right--;
                }
                if (left > right) {
                    return false;
                }
                m = 0;
                for (int i = left; i <= right; i++) {
                    m += A[i];
                }
            }
            return (l == part && m == part && r == part);
        }
    }

    public static void main(String[] args) {
        int[] test = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
//        int[] test = {1, -1, 1, -1};
        PartitionArrayIntoThreePartsWithEqualSum p = new PartitionArrayIntoThreePartsWithEqualSum();
        System.out.println(p.canThreePartsEqualSum(test));
    }
}
