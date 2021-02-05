package SlidingWindow;

public class GetEqualSubstringsWithinBudget {

    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0, res = 0, sum = 0;
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
