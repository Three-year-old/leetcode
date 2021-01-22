package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = 0;
        int k = K;
        while (k != 0) {
            k /= 10;
            length++;
        }
        int[] B = new int[length];
        int copy = length;
        while (K != 0) {
            B[--copy] = K % 10;
            K /= 10;
        }
        int p = 0;
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        while (p < A.length && p < length) {
            list.add((A[A.length - 1 - p] + B[length - 1 - p] + carry) % 10);
            carry = (A[A.length - 1 - p] + B[length - 1 - p] + carry) / 10;
            p++;
        }
        while (A.length > p) {
            list.add((A[A.length - 1 - p] + carry) % 10);
            carry = (A[A.length - 1 - p] + carry) / 10;
            p++;
        }
        while (length > p) {
            list.add((B[length - 1 - p] + carry) % 10);
            carry = (B[length - 1 - p] + carry) / 10;
            p++;
        }
        if (carry != 0) list.add(carry);
        Collections.reverse(list);
        return list;
    }
}
