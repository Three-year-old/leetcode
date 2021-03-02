package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] map = new int[26];
        int[] dp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
            dp[s.charAt(i) - 'a']++;
        }
        int left = 0;
        while (left <= s.length() - p.length()) {
            if (left != 0) {
                dp[s.charAt(left - 1) - 'a']--;
                dp[s.charAt(left + p.length() - 1) - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (map[i] != dp[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(left);
            left++;
        }
        return res;
    }
}
