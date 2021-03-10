package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, preLeft = 0, preRight = 0;
        cnt.put(s.charAt(0), cnt.getOrDefault(s.charAt(0), 0) + 1);
        String res = "";
        while (right < s.length()) {
            if (preLeft != left) cnt.put(s.charAt(preLeft), cnt.get(s.charAt(preLeft)) - 1);
            if (preRight != right) cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            preLeft = left;
            preRight = right;
            if (check()) {
                String substring = s.substring(left, right + 1);
                if (res.equals("") || res.length() > substring.length()) res = substring;
                left++;
            } else {
                right++;
            }
        }
        return res;
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            if (cnt.getOrDefault(entry.getKey(), 0) < entry.getValue()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("a", "aa"));
    }
}
