import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static boolean isSafe (int row,int col, char [][] board) {
        int n = board.length;
        // Check left side of the current row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check lower left diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void saveBoard (char [][] board, List<List<String >> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                }else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    public static void helper (char [][] board, List<List<String >> allBoards, int col){
        if (col == board.length) {
            saveBoard(board,allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++){
            if (isSafe(row,col,board)) {
                board[row][col] = 'Q';
                helper(board,allBoards,col+1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens (int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char [][] board = new char[n][n];
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, allBoards, 0);
        return allBoards;
    }
    public static void main (String [] args) {
        int n = 5;
        NQueens nq = new NQueens();
        List<List<String>> allBoards = nq.solveNQueens(n);
        // Print all solutions
        for (List<String> solution : allBoards) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println(); // Separate solutions
        }
    }
}
