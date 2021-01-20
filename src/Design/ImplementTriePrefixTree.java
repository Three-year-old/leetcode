package Design;

public class ImplementTriePrefixTree {

    private final TrieNode node;

    public ImplementTriePrefixTree() {
        node = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode root = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!root.containsKey(c)) {
                root.put(c, new TrieNode());
            }
            root = root.get(c);
        }
        root.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null && trieNode.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode root = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.containsKey(c)) {
                root = root.get(c);
            } else {
                return null;
            }
        }
        return root;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        return trieNode != null;
    }

    static class TrieNode {

        private boolean isEnd;

        private final TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public void put(char c, TrieNode trieNode) {
            links[c - 'a'] = trieNode;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
