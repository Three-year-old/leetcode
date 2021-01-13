package Tree;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] uf = new int[n + 1];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        for (int[] edge : edges) {
            int in = find(edge[0], uf);
            int out = find(edge[1], uf);
            if (in == out) {
                return edge;
            } else {
                merge(in, out, uf);
            }
        }
        return new int[]{};
    }

    private int find(int x, int[] uf) {
        if (x == uf[x]) return x;
        else {
            uf[x] = find(uf[x], uf);
            return uf[x];
        }
    }

    private void merge(int a, int b, int[] uf) {
        uf[find(a, uf)] = find(b, uf);
    }
}
