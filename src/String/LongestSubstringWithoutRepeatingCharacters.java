package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //从第一个字符开始
        //每次维护一个Set
        //当往后找的字符出现在Set时
        //清空Set并记录该值
        int max = 0;
        int record = 0;
        int i = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            int p = i;
            while (p < s.length() && !set.contains(s.charAt(p))) {
                set.add(s.charAt(p));
                p++;
                record++;
            }
            set.clear();
            max = Math.max(max, record);
            record = 0;
            i++;
        }
        return max;
    }
}
