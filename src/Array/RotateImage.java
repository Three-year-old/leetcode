package Array;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        if (length == 0) return;
        fuck(matrix, 0, length);
    }

    private void fuck(int[][] matrix, int start, int end) {
        if (start >= end) return;
        for (int i = start; i < end; i++) {
            cock(matrix, start, i);
        }
        fuck(matrix, start + 1, end - 1);
    }

    private void cock(int[][] matrix, int x, int y) {
        // matrix[x][y] -> matrix[y][last-x]
        // matrix[y][last-x] -> matrix[last-x][last-y]
        // matrix[last-x][last-y] -> matrix[last-y][x]
        // matrix[last-y][x] -> matrix[x][y]
        int last = matrix.length - 1;
        int pre = matrix[x][y];
        int cur = matrix[y][last - x];
        matrix[y][last - x] = pre;
        pre = matrix[last - x][last - y];
        matrix[last - x][last - y] = cur;
        cur = matrix[last - y][x];
        matrix[last - y][x] = pre;
        matrix[x][y] = cur;
    }
}
