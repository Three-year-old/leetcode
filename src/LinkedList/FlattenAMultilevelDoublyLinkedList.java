package LinkedList;

public class FlattenAMultilevelDoublyLinkedList {

    public MultiNode flatten(MultiNode head) {
        if (head == null) {
            return null;
        }
        MultiNode p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
            } else {
                MultiNode child = p.child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next = p.next;
                if (p.next != null) {
                    p.next.prev = child;
                }
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
        }
        return head;
    }
}

class MultiNode {
    public int val;
    public MultiNode prev;
    public MultiNode next;
    public MultiNode child;
}
