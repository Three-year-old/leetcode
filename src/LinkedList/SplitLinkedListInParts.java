package LinkedList;

import java.util.Arrays;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int[] arr = new int[k];
        int length = 0;
        ListNode p = root;
        while (p != null) {
            length++;
            p = p.next;
        }
        int j = length / k;
        int l = length % k;
        for (int i = 0; i < l; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < k; i++) {
            arr[i] += j;
        }
        for (int i = 0; i < arr.length; i++) {
            p = root;
            if (arr[i] == 0) {
                break;
            }
            int step = 1;
            while (step != arr[i]) {
                p = p.next;
                step++;
            }
            ListNode tmp = p.next;
            p.next = null;
            res[i] = root;
            root = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        int k = 5;
        SplitLinkedListInParts s = new SplitLinkedListInParts();
        ListNode[] listNodes = s.splitListToParts(root, k);
        System.out.println(Arrays.toString(listNodes));
    }
}
