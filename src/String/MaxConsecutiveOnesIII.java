package String;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int len = A.length, l = 0, r = 0;
        while (r < len) {
            if (A[r++] == 0) K--;
            if (K < 0 && A[l++] == 0) K++;
        }
        return r - l;
    }
}
