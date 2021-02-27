package DeepFirstSearch;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    private int res = 0;

    public int longestSubstring(String s, int k) {
        dfs(s, k);
        return res;
    }

    private void dfs(String st, int k) {
        int[] ch = new int[26];
        for (int i = 0; i < st.length(); i++) {
            ch[st.charAt(i) - 'a']++;
        }
        char split = '0';
        for (int i = 0; i < 26; i++) {
            if (ch[i] > 0 && ch[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == '0') {
            res = Math.max(res, st.length());
            return;
        }
        String[] str = st.split(String.valueOf(split));
        for (String s : str) {
            dfs(s, k);
        }
    }
}
