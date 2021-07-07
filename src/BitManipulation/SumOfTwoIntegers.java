package BitManipulation;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        return a == 0 ? b : getSum((a & b) << 1, a ^ b);
    }
}
