package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        if (window > s2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        int start = 0;
        for (int i = start; i < start + window; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        while (start <= s2.length() - window) {
            boolean flag = true;
            if (start != 0) {
                if (map2.get(s2.charAt(start - 1)) == 1) {
                    map2.remove(s2.charAt(start - 1));
                } else {
                    map2.put(s2.charAt(start - 1), map2.get(s2.charAt(start - 1)) - 1);
                }
                map2.put(s2.charAt(start + window - 1), map2.getOrDefault(s2.charAt(start + window - 1), 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                if (!map2.containsKey(entry.getKey())) {
                    flag = false;
                    break;
                }
                if (!map2.get(entry.getKey()).equals(entry.getValue())) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
            start++;
        }
        return false;
    }
}
