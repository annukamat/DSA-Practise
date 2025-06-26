// https://leetcode.com/problems/word-search/
import java.util.*;

public class wordSearch {

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) { // Start DFS only if the first letter matches
                    if (explore(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }

    public boolean explore(char[][] board, int i, int j, int word_i, String word) {
        // Base Case: If all characters matched
        if (word_i == word.length()) return true;

        // Out of bounds or character mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(word_i))
            return false;

        // Mark as visited
        char my_char = board[i][j];
        board[i][j] = '@';

        // Explore in all 4 directions
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (explore(board, r, c, word_i + 1, word)) {
                board[i][j] = my_char; // Restore original value
                return true;
            }
        }

        // Restore the board before backtracking
        board[i][j] = my_char;
        return false;
    }

}

