package Array;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        if (row == 0) {
            return new int[0][0];
        }
        int col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int one = M[i][j];
                int count = 1;
                if (i - 1 >= 0) {
                    count++;
                    one += M[i - 1][j];
                }
                if (j - 1 >= 0) {
                    count++;
                    one += M[i][j - 1];
                }
                if (i + 1 < row) {
                    count++;
                    one += M[i + 1][j];
                }
                if (j + 1 < col) {
                    count++;
                    one += M[i][j + 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    count++;
                    one += M[i - 1][j - 1];
                }
                if (i - 1 >= 0 && j + 1 < col) {
                    count++;
                    one += M[i - 1][j + 1];
                }
                if (i + 1 < row && j - 1 >= 0) {
                    count++;
                    one += M[i + 1][j - 1];
                }
                if (i + 1 < row && j + 1 < col) {
                    count++;
                    one += M[i + 1][j + 1];
                }
                res[i][j] = one / count;
            }
        }
        return res;
    }
}
