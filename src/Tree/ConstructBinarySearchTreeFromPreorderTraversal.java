package Tree;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int k = start + 1;
        while (k < preorder.length && preorder[k] < preorder[start]) {
            k++;
        }
        root.left = bstFromPreorder(preorder, start + 1, k - 1);
        root.right = bstFromPreorder(preorder, k, end);
        return root;
    }
}
