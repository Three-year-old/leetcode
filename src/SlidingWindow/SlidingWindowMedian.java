package SlidingWindow;

import java.util.Arrays;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        Prior priors = new Prior(k);
        for (int i = 0; i <= nums.length - k; i++) {
            while (priors.capacity < k) {
                priors.insert(nums[i + priors.capacity]);
            }
            if (i > 0) {
                priors.drop(nums[i - 1]);
                priors.insert(nums[i - 1 + k]);
            }
            if (k % 2 != 0) {
                res[i] = priors.get(k / 2) * 1.00000;
            } else {
                res[i] = priors.get(k / 2) * 1.00000 / 2 + priors.get(k / 2 - 1) * 1.00000 / 2;
            }
        }
        return res;
    }

    private static class Prior {

        private final int[] p;
        private int capacity;

        public Prior(int k) {
            p = new int[k];
            capacity = 0;
        }

        /**
         * insert value into array and make sure the array is sorted
         *
         * @param value value
         */
        public void insert(int value) {
            p[capacity] = value;
            capacity++;
            if (capacity == p.length) Arrays.sort(p);
        }

        /**
         * drop value from array and make sure the array is sorted
         *
         * @param value value
         */
        public void drop(int value) {
            for (int i = 0; i < p.length; i++) {
                if (p[i] == value) {
                    // from i to p.length, array move 1 to left
                    if (p.length - 1 - i >= 0) System.arraycopy(p, i + 1, p, i, p.length - 1 - i);
                    p[p.length - 1] = 0;
                    break;
                }
            }
            capacity--;
        }

        public int get(int index) {
            return p[index];
        }
    }
}
