package DynamicProgramming;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return search(s, 0, wordDict);
    }

    private boolean search(String s, int length, List<String> wordDict) {
        if (length == s.length()) {
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i), length)) {
                if (search(s, length + wordDict.get(i).length(), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
