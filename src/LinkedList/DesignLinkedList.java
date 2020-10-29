package LinkedList;

public class DesignLinkedList extends ListNode {

    private ListNode head;

    private int length;

    /**
     * Initialize your data structure here.
     */
    public DesignLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode p = head;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p == null ? -1 : p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        tmp.next = head;
        head = tmp;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
        } else {
            ListNode p = head;
            while (index > 1) {
                index--;
                p = p.next;
            }
            ListNode tmp = p.next;
            p.next = new ListNode(val);
            p.next.next = tmp;
        }
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= length) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode p = head;
            while (index > 1) {
                index--;
                p = p.next;
            }
            p.next = p.next.next;
        }
        length--;
    }
}
