package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    private List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i < 3) {
                int k = i;
                while (k > 0) {
                    tmp.add(1);
                    k--;
                }
            } else {
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        tmp.add(1);
                    } else {
                        tmp.add(res.get(i - 2).get(j) + res.get(i - 2).get(j - 1));
                    }
                }
            }
            res.add(tmp);
        }
        return res.get(rowIndex);
    }

    public static void main(String[] args) {
        PascalTriangleII p = new PascalTriangleII();
        System.out.println(p.getRow(6));
    }
}
