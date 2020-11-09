package Array;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + len)) {
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
