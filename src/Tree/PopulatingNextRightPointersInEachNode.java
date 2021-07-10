package Tree;

public class PopulatingNextRightPointersInEachNode {

    public PNode connect(PNode root) {
        if (root == null) return null;
        root.left = connect(root.left, root.right);
        root.right = connect(root.right, null);
        return root;
    }

    public PNode connect(PNode left, PNode right) {
        if (left == null) return null;
        left.next = right;
        left.left = connect(left.left, left.right);
        if (right == null) {
            left.right = connect(left.right, null);
        } else {
            left.right = connect(left.right, right.left);
        }
        return left;
    }

    static class PNode {
        public int val;
        public PNode left;
        public PNode right;
        public PNode next;

        public PNode() {}

        public PNode(int _val) {
            val = _val;
        }

        public PNode(int _val, PNode _left, PNode _right, PNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
