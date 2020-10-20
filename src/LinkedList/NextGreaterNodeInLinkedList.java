package LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            A.add(p.val);
        }
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }
}
