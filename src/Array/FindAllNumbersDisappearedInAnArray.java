package Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    private List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] status = new boolean[nums.length];
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            status[num - 1] = true;
        }
        for (int i = 0; i < status.length; i++) {
            if (!status[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
