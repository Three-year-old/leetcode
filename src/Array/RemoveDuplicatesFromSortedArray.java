package Array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 2, 2, 3, 3};
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int res = r.removeDuplicates(test);
        System.out.println(res);
        System.out.println(Arrays.toString(test));
    }
}
