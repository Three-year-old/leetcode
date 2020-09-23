package Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        int point = 0;
        TreeNode tree = new TreeNode(root);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                point = i;
                break;
            }
        }
        int[] leftPreOrder = new int[point];
        int[] rightPreOrder = new int[preorder.length - 1 - point];
        int[] leftInOrder = new int[point];
        int[] rightInOrder = new int[preorder.length - 1 - point];
        for (int i = 0; i < point; i++) {
            leftInOrder[i] = inorder[i];
            leftPreOrder[i] = preorder[i + 1];
        }
        for (int i = point + 1; i < preorder.length; i++) {
            rightInOrder[i - point - 1] = inorder[i];
            rightPreOrder[i - point - 1] = preorder[i];
        }
        tree.left = buildTree(leftPreOrder, leftInOrder);
        tree.right = buildTree(rightPreOrder, rightInOrder);
        return tree;
    }
}
