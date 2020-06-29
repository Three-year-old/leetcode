package Array;

public class SearchInsertPosition {

    private int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] test = {1,3,5,6};
        int target = 5;
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int result = searchInsertPosition.searchInsert(test, target);
        System.out.println(result);
    }
}
