package String;

import java.math.BigInteger;

public class AdditiveNumber {
    public boolean res = false;

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                dfs(0, i, j, num);
            }
        }
        return res;
    }

    private void dfs(int offset, int start, int end, String num) {
        if (end >= num.length()) return;
        String first = num.substring(offset, start);
        String second = num.substring(start, end);
        if ((!first.equals("0") && first.startsWith("0")) || (!second.equals("0") && second.startsWith("0"))) return;
        String ans = add(first, second);
        assert ans != null;
        if (!num.startsWith(ans, end)) {
            return;
        }
        if (num.substring(end).equals(ans)) {
            res = true;
            return;
        }
        for (int i = start + 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                dfs(start, i, j, num);
            }
        }
    }

    private String add(String a, String b) {
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }
}