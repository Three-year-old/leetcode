package DynamicProgramming;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        if (col == 0) return 0;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    left[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    left[i][j] = matrix[i][j] == '0' ? 0 : 1 + left[i][j - 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int height = 0, k = j, min = left[j][i];
                while (k >= 0 && left[k][i] != 0) {
                    height++;
                    min = Math.min(min, left[k][i]);
                    k--;
                    res = Math.max(res, height * min);
                }
            }
        }
        return res;
    }
}
