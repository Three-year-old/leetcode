package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length != pushed.length) return false;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int k : popped) {
            queue.offer(k);
        }
        for (int j : pushed) {
            stack.push(j);
            while (!stack.isEmpty() && stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
            }
        }
        return stack.isEmpty();
    }
}
