package String;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        boolean[] flag = new boolean[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            map[c - 'a']++;
        }

        StringBuilder str = new StringBuilder();
        for (char c : cs) {
            if (str.length() == 0 || str.charAt(str.length() - 1) < c) {
                if (!flag[c - 'a']) {
                    str.append(c);
                    flag[c - 'a'] = true;
                }
            } else {
                if (flag[c - 'a']) {
                    map[c - 'a']--;
                    continue;
                }

                while (str.length() != 0 && map[str.charAt(str.length() - 1) - 'a'] > 1 && str.charAt(str.length() - 1) >= c) {
                    map[str.charAt(str.length() - 1) - 'a']--;
                    flag[str.charAt(str.length() - 1) - 'a'] = false;
                    str.deleteCharAt(str.length() - 1);
                }

                str.append(c);
                flag[c - 'a'] = true;
            }
        }

        return str.toString();
    }
}
