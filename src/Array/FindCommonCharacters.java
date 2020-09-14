package Array;

import java.util.*;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        // 返回的字符必须出现在给定的所有单词中
        // 其次要计算出现的次数
        //
        List<String> result = new ArrayList<>();
        int[][] characters = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].toCharArray().length; j++) {
                characters[i][A[i].toCharArray()[j] - 'a']++;
            }
        }
        for (int col = 0; col < characters[0].length; col++) {
            int count = Integer.MAX_VALUE;
            for (int[] character : characters) {
                count = Math.min(count, character[col]);
            }
            if (count > 0) {
                while (count > 0) {
                    result.add(String.valueOf((char)('a' + col)));
                    count--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"bella", "label", "roller"};
        FindCommonCharacters f = new FindCommonCharacters();
        System.out.println(f.commonChars(test));
    }
}
