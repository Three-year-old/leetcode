package Greedy;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;
        int flag = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (flag == 0) {
                    continue;
                } else {
                    count++;
                    flag = 0;
                }
            } else if (nums[i] < nums[i - 1]) {
                if (flag == 1) {
                    continue;
                } else {
                    count++;
                    flag = 1;
                }
            } else {
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test = {0, 0};
        WiggleSubsequence w = new WiggleSubsequence();
        System.out.println(w.wiggleMaxLength(test));
    }
}
