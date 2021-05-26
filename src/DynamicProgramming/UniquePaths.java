package DynamicProgramming;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }
        for (int u = 1; u < m; u++) {
            for (int v = 1; v < n; v++) {
                res[u][v] = res[u-1][v] + res[u][v-1];
            }
        }
        return res[m-1][n-1];
    }
}
