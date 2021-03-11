package DynamicProgramming;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String res = "";
        for (int l = 0; l < length; l++) {
            for (int i = 0; i + l < length; i++) {
                int j = i + l;
                if (i == j) dp[i][j] = true;
                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) dp[i][j] = b;
                    else dp[i][j] = b && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
