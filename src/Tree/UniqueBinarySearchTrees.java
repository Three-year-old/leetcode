package Tree;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numTrees(i - 1) * numTrees(n - i);
        }
        return count;
    }
}
