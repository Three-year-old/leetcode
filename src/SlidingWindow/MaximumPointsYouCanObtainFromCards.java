package SlidingWindow;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int copy = k, backup = k, sum = 0;
        int start = cardPoints.length - k;
        while (backup > 0) {
            sum += cardPoints[start % cardPoints.length];
            start++;
            backup--;
        }
        int res = sum;
        while (--copy >= 0) {
            sum -= cardPoints[(cardPoints.length - copy - 1) % cardPoints.length];
            sum += cardPoints[(cardPoints.length + k - 1 - copy) % cardPoints.length];
            res = Math.max(res, sum);
        }
        return res;
    }
}
