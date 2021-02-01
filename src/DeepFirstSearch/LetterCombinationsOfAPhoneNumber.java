package DeepFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private final Map<Integer, List<Character>> map = new HashMap<>();

    private final List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        init(digits);
        StringBuffer buffer = new StringBuffer();
        dfs(digits, 0, buffer);
        return res;
    }

    private void dfs(String digits, int start, StringBuffer buffer) {
        if (start == digits.length()) res.add(String.valueOf(buffer));
        if (start >= digits.length()) return;
        int index = digits.charAt(start) - '0';
        List<Character> list = map.get(index);
        for (Character character : list) {
            StringBuffer copy = new StringBuffer();
            int p = start + 1;
            copy.append(buffer);
            copy.append(character);
            dfs(digits, p, copy);
        }
    }

    private void init(String s) {
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - '0';
            List<Character> list = new ArrayList<>();
            switch (j) {
                case 2:
                    list.add('a');
                    list.add('b');
                    list.add('c');
                    break;
                case 3:
                    list.add('d');
                    list.add('e');
                    list.add('f');
                    break;
                case 4:
                    list.add('g');
                    list.add('h');
                    list.add('i');
                    break;
                case 5:
                    list.add('j');
                    list.add('k');
                    list.add('l');
                    break;
                case 6:
                    list.add('m');
                    list.add('n');
                    list.add('o');
                    break;
                case 7:
                    list.add('p');
                    list.add('q');
                    list.add('r');
                    list.add('s');
                    break;
                case 8:
                    list.add('t');
                    list.add('u');
                    list.add('v');
                    break;
                case 9:
                    list.add('w');
                    list.add('x');
                    list.add('y');
                    list.add('z');
                    break;
            }
            map.put(j, list);
        }
    }
}
