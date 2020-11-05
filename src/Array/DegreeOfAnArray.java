package Array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).set(0, map.get(nums[i]).get(0) + 1);
                if (map.get(nums[i]).size() == 2) {
                    map.get(nums[i]).add(i);
                } else {
                    map.get(nums[i]).set(2, i);
                }
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(1);
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(map.get(key).get(0), max);
        }
        int res = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key).get(0) == max) {
                if (map.get(key).size() == 3) {
                    res = Math.min(res, map.get(key).get(2) - map.get(key).get(1));
                } else {
                    return 1;
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2, 3, 1};
        DegreeOfAnArray d = new DegreeOfAnArray();
        System.out.println(d.findShortestSubArray(test));
    }
}
