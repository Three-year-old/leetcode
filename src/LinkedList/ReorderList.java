package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> link = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            link.add(p);
            p = p.next;
        }
        for (int i = 0; i < link.size() / 2; i++) {
            link.get(i).next = link.get(link.size() - 1 - i);
            if (i != (link.size() / 2 - 1)) {
                link.get(link.size() - 1 - i).next = link.get(i + 1);
            } else {
                if (link.size() % 2 == 0) {
                    link.get(link.size() - 1 - i).next = null;
                } else {
                    link.get(link.size() - 1 - i).next = link.get(link.size() / 2);
                    link.get(link.size() / 2).next = null;
                }
            }
        }
        head = link.get(0);
    }
}
