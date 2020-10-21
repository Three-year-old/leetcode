package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int p = 0;
        int res = 0;
        boolean flag = true;
        while (head != null) {
            list.add(head.val);
            map.put(head.val, p++);
            head = head.next;
        }
        for (int j : G) {
            list.set(map.get(j), -1);
        }
        for (Integer integer : list) {
            if (integer == -1 && flag) {
                res++;
                flag = false;
            }
            if (integer != -1) {
                flag = true;
            }
        }
        return res;
    }
}
