package Design;

import java.util.HashMap;

public class LRUCache {

    static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final HashMap<Integer, ListNode> map;

    private ListNode head;

    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            //node -> head
            move(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            //node -> head
            move(node);
        } else if (map.size() >= capacity) {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            //add node
            move(node);
            //delete tail
            delete();
        } else {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            if (head == null) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            head = node;
        }
    }

    private void move(ListNode node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = node.prev;
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
        node.prev = null;
        node.next = head;
        if(head != null)
            head.prev = node;
        head = node;
        if (tail == null)
            tail = head;
    }

    private void delete() {
        if (tail != null) {
            tail.prev.next = null;
            map.remove(tail.key);
            tail = tail.prev;
        }
    }
}
