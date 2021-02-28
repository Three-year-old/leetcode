package Array;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;
        int p = 0;
        while (p < A.length && A[p] == A[0]) p++;
        if (p == A.length) return true;
        int diff = A[p] - A[0];
        for (int i = p; i < A.length - 1; i++) {
            if ((A[i + 1] - A[i]) * diff < 0) return false;
        }
        return true;
    }
}
