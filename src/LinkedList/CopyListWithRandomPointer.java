package LinkedList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Node q;
        while (p != null) {
            q = new Node(p.val);
            Node tmp = p.next;
            p.next = q;
            q.next = tmp;
            p = tmp;
        }
        p = head;
        while (p != null) {
            q = p.next;
            if (p.random == null) {
                q.random = null;
            } else {
                q.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        q = head.next;
        Node res = head.next;
        while (p != null && q != null) {
            p.next = p.next.next;
            if (q.next == null) {
                break;
            }
            q.next = q.next.next;
            q = q.next;
            p = p.next;
        }
        return res;
    }
}
