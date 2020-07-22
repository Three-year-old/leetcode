package Array;

public class JumpGame {

    private boolean canJump(int[] nums) {
        // 能看到的最远距离
        int most = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= most){
                most = Math.max(most, nums[i] + i);
                if (most >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 8, 2, 0, 0, 1};
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(test));
    }
}
