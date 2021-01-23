package Array;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int count = 0;
        for (int j : A) {
            count = (count * 2 + j) % 5;
            res.add(count == 0);
        }
        return res;
    }
}
