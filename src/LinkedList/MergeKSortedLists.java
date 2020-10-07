package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                priorityQueue.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode p = new ListNode(0);
        ListNode head = p;
        while (!priorityQueue.isEmpty()) {
            p.next = new ListNode(priorityQueue.peek());
            priorityQueue.poll();
            p = p.next;
        }
        return head.next;
    }
}
