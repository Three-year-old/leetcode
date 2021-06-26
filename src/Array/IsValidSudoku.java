package Array;

import java.util.Arrays;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[] hash = new boolean[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(hash, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (hash[board[i][j] - '0']) return false;
                hash[board[i][j] - '0'] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            Arrays.fill(hash, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (hash[board[j][i] - '0']) return false;
                hash[board[j][i] - '0'] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(hash, false);
                for (int n = i * 3; n < i * 3 + 3; n++) {
                    for (int m = j * 3; m < j * 3 + 3; m++) {
                        if (board[m][n] == '.') continue;
                        if (hash[board[m][n] - '0']) return false;
                        hash[board[m][n] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
