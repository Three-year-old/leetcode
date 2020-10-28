package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        int length1 = 0, length2 = 0;
        while (p1 != null) {
            length1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            length2++;
            p2 = p2.next;
        }
        p1 = l1;
        p2 = l2;
        List<Integer> carry = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int sub = Math.abs(length1 - length2);
        if (length1 > length2) {
            while (sub > 0) {
                res.add(p1.val);
                carry.add(0);
                p1 = p1.next;
                sub--;
            }
        } else {
            while (sub > 0) {
                res.add(p2.val);
                carry.add(0);
                p2 = p2.next;
                sub--;
            }
        }
        while (p1 != null && p2 != null) {
            res.add((p1.val + p2.val) % 10);
            carry.add((p1.val + p2.val) / 10);
            p1 = p1.next;
            p2 = p2.next;
        }
        carry.add(0);
        List<Integer> ans = new ArrayList<>();
        int c = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add((c + res.get(i) + carry.get(i)) % 10);
            c = (c + res.get(i) + carry.get(i)) / 10;
        }
        if (c > 0) {
            ans.add(c);
        }
        Collections.reverse(ans);
        while (ans.size() > 0 && ans.get(0) == 0) {
            ans.remove(0);
        }
        if (ans.size() == 0) {
            return new ListNode(0);
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (Integer an : ans) {
            p.next = new ListNode(an);
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        AddTwoNumbersII a = new AddTwoNumbersII();
        ListNode p = a.addTwoNumbers(l1, l2);
    }
}
