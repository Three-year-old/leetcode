package Array;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        int result = 0;
        for (int j : flowerbed) {
            if (j == 0) {
                count++;
            } else {
                result += (count - 1) / 2;
                count = 0;
            }
        }
        if (count != 0) result += count / 2;
        return result >= n;
    }
}
