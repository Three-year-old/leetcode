package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o2[0] == o1[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        List<List<Integer>> result = new ArrayList<>();
        for (int[] person : people) {
            List<Integer> temp = new ArrayList<>();
            temp.add(person[0]);
            temp.add(person[1]);
            if (person[1] >= result.size()) {
                result.add(temp);
            } else {
                result.add(person[1], temp);
            }
        }
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }
}
