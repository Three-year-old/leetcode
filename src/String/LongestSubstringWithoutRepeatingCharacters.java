package String;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, right = 0, res = 0;
        int[] status = new int[128];
        while (right < s.length()) {
            if (status[s.charAt(right)] == 0) {
                status[s.charAt(right)]++;
                right++;
            } else {
                status[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
