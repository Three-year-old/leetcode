package DeepFirstSearch;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int count = 0;
        boolean[] visit = new boolean[provinces];
        for (int i = 0; i < provinces; i++) {
            if (!visit[i]) {
                count++;
                dfs(isConnected, i, visit);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visit) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(isConnected, j, visit);
            }
        }
    }
}
