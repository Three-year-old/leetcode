package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
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
        return res;
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(6));
    }
}
