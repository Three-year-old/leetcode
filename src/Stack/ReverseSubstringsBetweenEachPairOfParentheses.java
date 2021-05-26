package Stack;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                reverse(c, stack.pop(), i);
            }
        }
        return String.valueOf(c).replaceAll("\\(|\\)", "");
    }

    public void reverse(char[] s, int start, int end) {
        int left = start + 1, right = end - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
