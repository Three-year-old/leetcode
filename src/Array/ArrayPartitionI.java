package Array;

import java.util.Arrays;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                count += nums[i];
            }
        }
        return count;
    }
}
