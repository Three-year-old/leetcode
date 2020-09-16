package Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
//                if (nums[i] == nums[j] && j - i <= k) {
//                    return true;
//                }
//            }
//        }
//        return false;
        // 只做一次遍历
        // 利用HashMap
        // HashMap中存储数组中元素值与索引键值对
        // 当遍历时遇到相同key时判断索引位置之差是否在k大小内
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
