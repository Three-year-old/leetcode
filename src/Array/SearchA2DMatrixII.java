package Array;

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        if (row < 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
