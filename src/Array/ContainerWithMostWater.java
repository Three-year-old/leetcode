package Array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int n = height.length;//n > 1
        int max = 0;
        for (int i = 0; i < n; i++) {
            //计算以第i个柱子为左边，所能装的最大水
            int res = 0;
            for (int j = i; j < n; j++) {
                res = Math.max(res, (j - i) * Math.min(height[j], height[i]));
            }
            max = Math.max(res, max);
        }
        return max;
    }
}
