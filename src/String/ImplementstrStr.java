package String;

public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        return indexOf(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
    }

    static int indexOf(char[] source, int sourceCount, char[] target, int targetCount) {
        if (sourceCount <= 0) return targetCount == 0 ? sourceCount : -1;
        if (targetCount == 0) return 0;

        char first = target[0];
        int max = sourceCount - targetCount;

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++) ;
                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
}
