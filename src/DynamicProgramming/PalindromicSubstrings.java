package DynamicProgramming;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int len = 0; len < length; len++) {
            for (int row = 0; row + len < length; row++) {
                int col = row + len;
                if (len == 0) dp[row][col] = true;
                else {
                    final boolean e = s.charAt(row) == s.charAt(col);
                    if (len == 1) dp[row][col] = e;
                    else dp[row][col] = e && dp[row + 1][col - 1];
                }
            }
        }
        int count = 0;
        for (boolean[] booleans : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                if (booleans[j]) count++;
            }
        }
        return count;
    }
}
