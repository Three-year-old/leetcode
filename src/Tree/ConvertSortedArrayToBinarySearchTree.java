package Tree;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int root = nums[nums.length / 2];
        TreeNode tree = new TreeNode(root);
        int leftSize, rightSize;
        if ((nums.length - 1) % 2 == 0) {
            leftSize = (nums.length - 1) / 2;
        } else {
            leftSize = (nums.length - 1) / 2 + 1;
        }
        rightSize = (nums.length - 1) / 2;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        System.arraycopy(nums, 0, left, 0, leftSize);
        for (int i = leftSize + 1; i < nums.length; i++) {
            right[i - leftSize - 1] = nums[i];
        }
        tree.left = sortedArrayToBST(left);
        tree.right = sortedArrayToBST(right);
        return tree;
    }
}
