package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class CouplesHoldingHands {

    public int minSwapsCouples(int[] row) {
        int[] uf = new int[row.length / 2];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            merge(uf, row[i] / 2, row[i + 1] / 2);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length / 2; i++) {
            int fx = find(uf, i);
            map.put(fx, map.getOrDefault(fx, 0) + 1);
        }
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ret += entry.getValue() - 1;
        }
        return ret;
    }

    private int find(int[] uf, int k) {
        while (uf[k] != k) {
            uf[k] = uf[uf[k]];
            k = uf[k];
        }
        return uf[k];
    }

    private void merge(int[] uf, int x, int y) {
        uf[find(uf, x)] = find(uf, y);
    }
}
