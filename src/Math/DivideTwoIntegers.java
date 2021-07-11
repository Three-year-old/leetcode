package Math;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) return 0;

        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = -1;
        }
        return flag * divide(Math.abs((long) dividend), Math.abs((long) divisor));
    }

    private int divide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        int count = 1;
        long copy = divisor;
        while (dividend > (copy + copy)) {
            copy += copy;
            count += count;
        }
        return count + divide(dividend - copy, divisor);
    }
}
