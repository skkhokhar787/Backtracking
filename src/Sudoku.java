public class Sudoku {
    public static boolean helper (char [][] board, int row, int col) {

        int nRow = 0;
        int nCol = 0;

        if (col == board.length-1) {
            nRow = row + 1;
        }
        if (row == board.length-1) {
            nCol = col + 1;
        }
        if (board[row][col] != '.') {
            if (helper(board, row, col)) {
                return true;
            }
        }else {

            for (int i = 1; i <= 9; i++) {

            }
        }
        return true;
    }
    public static void main (String [] args) {

    }
}
