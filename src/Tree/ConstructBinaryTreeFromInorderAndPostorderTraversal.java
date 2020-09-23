package Tree;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int point = 0;
        int root = postorder[postorder.length - 1];
        TreeNode tree = new TreeNode(root);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                point = i;
                break;
            }
        }
        int[] leftPostOrder = new int[point];
        int[] rightPostOrder = new int[postorder.length - 1 - point];
        int[] leftInOrder = new int[point];
        int[] rightInOrder = new int[postorder.length - 1 - point];
        for (int i = 0; i < point; i++) {
            leftInOrder[i] = inorder[i];
            leftPostOrder[i] = postorder[i];
        }
        for (int i = point + 1; i < postorder.length; i++) {
            rightInOrder[i - point - 1] = inorder[i];
            rightPostOrder[i - point - 1] = postorder[i - 1];
        }
        tree.left = buildTree(leftInOrder, leftPostOrder);
        tree.right = buildTree(rightInOrder, rightPostOrder);
        return tree;
    }
}
