package BitManipulation;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int s = x ^ y, c = 0;
        while (s != 0) {
            c += s & 1;
            s >>= 1;
        }
        return c;
    }
}
