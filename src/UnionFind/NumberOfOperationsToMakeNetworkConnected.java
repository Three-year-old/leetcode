package UnionFind;

public class NumberOfOperationsToMakeNetworkConnected {

    private int[] uf;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        int dup = n;
        for (int[] connection : connections) {
            if (find(connection[0]) != find(connection[1])) {
                merge(connection[0], connection[1]);
                dup--;
            }
        }
        return dup - 1;
    }

    private int find(int k) {
        if (uf[k] == k) return k;
        else {
            uf[k] = find(uf[k]);
            return uf[k];
        }
    }

    private void merge(int x, int y) {
        uf[find(x)] = find(y);
    }
}
