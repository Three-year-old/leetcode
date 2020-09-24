package Array;

public class SearchA2DMatrix {

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

    public static void main(String[] args) {
        int[][] test = {{1, 3}};
        SearchA2DMatrix s = new SearchA2DMatrix();
        System.out.println(s.searchMatrix(test, 3));
    }
}
