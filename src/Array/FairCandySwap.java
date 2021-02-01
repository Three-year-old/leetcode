package Array;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int SumA = 0, SumB = 0;
        for (int a : A) {
            SumA += a;
        }
        for (int b : B) {
            SumB += b;
        }
        int n = (SumB - SumA) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : B) {
            set.add(i);
        }
        for (int i : A) {
            if (set.contains(i + n)) {
                return new int[] {i, i + n};
            }
        }
        return null;
    }
}
