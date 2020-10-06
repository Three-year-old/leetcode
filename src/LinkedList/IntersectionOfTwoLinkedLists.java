package LinkedList;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //两个指针一起走
        //当某个指针为空时说明该链表到了尾节点
        //这时将该指针指向另外一个链表头节点继续
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
