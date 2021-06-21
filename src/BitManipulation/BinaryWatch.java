package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (countOne(i) + countOne(j) == turnedOn) {
                    if (j < 10) {
                        res.add(i + ":0" + j);
                    } else {
                        res.add(i + ":" + j);
                    }
                }
            }
        }
        return res;
    }

    public int countOne(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
