package TwoPointers;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] x = new int[26];
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            x[s.charAt(right) - 'A']++;
            max = Math.max(max, x[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                x[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
