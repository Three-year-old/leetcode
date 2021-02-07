package Stack;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> count = new Stack<>();
        Stack<String> stack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = 10 * num + (s.charAt(idx) - '0');
                    idx++;
                }
                count.push(num);
            } else if (s.charAt(idx) == '[') {
                stack.push(res.toString());
                res = new StringBuilder();
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder builder = new StringBuilder(stack.pop());
                Integer pop = count.pop();
                builder.append(res.toString().repeat(Math.max(0, pop)));
                res = builder;
                idx++;
            } else {
                res.append(s.charAt(idx++));
            }
        }
        return res.toString();
    }
}
