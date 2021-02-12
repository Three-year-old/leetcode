package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    private List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row[j] += row[j - 1];
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(row[i]);
        }
        return res;
    }
}
