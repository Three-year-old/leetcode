package UnionFind;

public class BricksFallingWhenHit {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        boolean[][] stable = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            stable[i][0] = (grid[i][0] == 1);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (grid[i][j - 1] == 1) {
                        stable[i][j] = true;
                        continue;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        stable[i][j] = true;
                        continue;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        stable[i][j] = true;
                    }
                }
            }
        }
        int[] res = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            if (!stable[hits[i][0]][hits[i][1]]) res[i] = 0;
            else {
                int count = 0;
                res[i] = count;
            }
        }
        return res;
    }
}
