package Array;

import java.util.Arrays;

public class RemoveElement {

    private int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 2, 3};
        int val = 3;
        RemoveElement r = new RemoveElement();
        int res = r.removeElement(test, val);
        System.out.println(res);
        System.out.println(Arrays.toString(test));
    }
}
