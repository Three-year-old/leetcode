package DeepFirstSearch;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = dfs(board, word, 0, i, j);
                    if (flag) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int start, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (start == word.length() - 1) return board[x][y] == word.charAt(start);
        if (board[x][y] != word.charAt(start)) return false;
        char copy = board[x][y];
        board[x][y] = '0';
        boolean left = dfs(board, word, start + 1, x - 1, y);
        if (left) return true;
        boolean right = dfs(board, word, start + 1, x + 1, y);
        if (right) return true;
        boolean down = dfs(board, word, start + 1, x, y - 1);
        if (down) return true;
        boolean up = dfs(board, word, start + 1, x, y + 1);
        if (up) return true;
        board[x][y] = copy;
        return false;
    }
}
