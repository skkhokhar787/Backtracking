public class SudokuSolver {
    public static boolean isSafe (char [][] board, int row, int col, int number) {
        // row & col
        for (int i = 0; i < board.length; i++) {
            if (board [i][col] == (char) (number + '0')){
                return false;
            }
            if (board[row][i] == (char) (number + '0')){
                return false;
            }
        }
        // grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++){
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean helper (char [][] board,int row, int col) {
        if (row == board.length){
            return true;
        }

        int nRow = 0;
        int nCol = 0;
        if (col != board.length-1) {
            nRow = row;
            nCol = col+1;
        }else {
            nRow = row+1;
        }

        if (board[row][col] != '.') {
            if (helper(board, nRow, nCol)){
                return true;
            }
        }else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board [row][col] = (char) (i+'0');
                    if (helper(board, nRow,nCol)){
                        return true;
                    }else {
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }
    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String [] args) {
        char [][] board = {
                {'5', '3', '.','.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        helper(board, 0,0);
        printBoard(board);


    }
}
