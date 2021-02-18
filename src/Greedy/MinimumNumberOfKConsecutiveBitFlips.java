package Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfKConsecutiveBitFlips {

    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != (queue.size() % 2 == 0 ? 0 : 1)) {
                res++;
                queue.add(i + K - 1);
            }
            if (!queue.isEmpty() && queue.peek() <= i) queue.poll();
        }
        return queue.isEmpty() ? res : -1;
    }
}
