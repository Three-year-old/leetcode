package Array;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        for (int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
        }
        int count = 0;
        int[] res = new int[60];
        for (int j : time) {
            res[j]++;
        }
        for (int i = 1; i < 30; i++) {
            count += res[i] * res[60 - i];
        }
        count += res[0] * (res[0] - 1) / 2;
        count += res[30] * (res[30] - 1) / 2;
        return count;
    }

    public static void main(String[] args) {
        int[] test = {269, 230, 318, 468, 171, 158, 350, 60, 287, 27, 11, 384, 332, 267, 412, 478, 280, 303, 242, 378, 129, 131, 164, 467, 345, 146, 264, 332, 276, 479, 284, 433, 117, 197, 430, 203, 100, 280, 145, 287, 91, 157, 5, 475, 288, 146, 370, 199, 81, 428, 278, 2, 400, 23, 470, 242, 411, 470, 330, 144, 189, 204, 62, 318, 475, 24, 457, 83, 204, 322, 250, 478, 186, 467, 350, 171, 119, 245, 399, 112, 252, 201, 324, 317, 293, 44, 295, 14, 379, 382, 137, 280, 265, 78, 38, 323, 347, 499, 238, 110, 18, 224, 473, 289, 198, 106, 256, 279, 275, 349, 210, 498, 201, 175, 472, 461, 116, 144, 9, 221, 473};
        PairsOfSongsWithTotalDurationsDivisibleBy60 p = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        System.out.println(p.numPairsDivisibleBy60(test));
    }
}
