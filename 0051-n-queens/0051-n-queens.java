import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Tracking sets to maintain invalid positions in O(1) time
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + (n - 1)
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col

        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2, 
                           List<List<String>> result) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Check if column or diagonals are already occupied
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place Queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Recurse to next row
            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            // Backtrack
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> formatted = new ArrayList<>();
        for (char[] row : board) {
            formatted.add(new String(row));
        }
        return formatted;
    }
}