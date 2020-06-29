package Array;

import java.util.Arrays;

public class SortArrayByParityII {

    private int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int odd = 1;
        int even = 0;
        for (int value : A) {
            if (value % 2 == 0) {
                res[even] = value;
                even += 2;
            } else {
                res[odd] = value;
                odd += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {4, 2, 5, 7};
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] result = sortArrayByParityII.sortArrayByParityII(test);
        System.out.println(Arrays.toString(result));
    }
}
