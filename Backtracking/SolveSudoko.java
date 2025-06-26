public class SolveSudoko {

    public void solveSudoku(char[][] board) {
        solve_(board);
    }

    public boolean solve_(char[][] board) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid_(board, i, j, ch)) {
                            board[i][j] = ch;

                            if (solve_(board)) return true;
                            else board[i][j] = '.'; // Backtrack
                        }
                    }

                    return false; // No valid number fits here
                }
            }
        }

        return true; // Fully filled
    }

    public boolean isValid_(char[][] board, int row, int col, char ch) {
        for (int idx = 0; idx < 9; idx++) {
            if (board[row][idx] == ch) return false;
            if (board[idx][col] == ch) return false;

            int sub_r = 3 * (row / 3) + idx / 3;
            int sub_c = 3 * (col / 3) + idx % 3;
            if (board[sub_r][sub_c] == ch) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        
    }
}
