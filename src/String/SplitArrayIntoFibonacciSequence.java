package String;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String S) {
        for (int i = 1; i < S.length(); i++) {
            for (int j = i + 1; j < S.length(); j++) {
                if (S.substring(0, i).length() > 1 && S.substring(0, i).startsWith("0")) {
                    continue;
                }
                if (S.substring(i, j).length() > 1 && S.substring(i, j).startsWith("0")) {
                    continue;
                }
                int first = convert(S.substring(0, i));
                int second = convert(S.substring(i, j));
                List<Integer> list = new ArrayList<>();
                if (judge(first, second, S.substring(j), list)) {
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean judge(int first, int second, String s, List<Integer> list) {
        String result = String.valueOf(first + second);
        if (list.size() != 0) {
            list.remove(list.size() - 1);
        }
        list.add(first);
        list.add(second);
        if (result.length() == s.length()) {
            if (result.equals(s)) {
                list.add(Integer.valueOf(result));
            }
            return result.equals(s);
        } else if (result.length() > s.length()) {
            return false;
        } else {
            if (s.regionMatches(0, result, 0, result.length())) {
                String tmp = s.substring(result.length());
                return judge(second, first + second, tmp, list);
            } else {
                return false;
            }
        }
    }

    private int convert(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Math.pow(10, s.length() - 1 - i) * (s.charAt(i) - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        String string = "123456579";
        SplitArrayIntoFibonacciSequence s = new SplitArrayIntoFibonacciSequence();
        List<Integer> list = s.splitIntoFibonacci(string);
        System.out.println(list);
    }
}
