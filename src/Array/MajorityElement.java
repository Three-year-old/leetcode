package Array;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else if (count != 0) {
                count--;
            } else {
                count++;
                major = nums[i];
            }
        }
        return major;
    }
}
