package Array;

public class FindTheDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int value : arr1) {
            int flag = 0;
            for (int i : arr2) {
                if (Math.abs(value - i) <= d) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count++;
            }
        }
        return count;
    }
}
