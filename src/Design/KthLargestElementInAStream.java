package Design;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private final int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        assert queue.peek() != null;
        return queue.peek();
    }
}
