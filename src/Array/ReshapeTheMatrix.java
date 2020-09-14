package Array;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if (row == 0) {
            return new int[0][0];
        }
        int col = nums[0].length;
        if (r * c != row * col) {
            return nums;
        }
        int[][] result = new int[r][c];
        int[] tmp = new int[r * c];
        int index = 0;
        for (int[] num : nums) {
            for (int j = 0; j < col; j++) {
                tmp[index++] = num[j];
            }
        }
        index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = tmp[index++];
            }
        }
        return result;
    }
}
