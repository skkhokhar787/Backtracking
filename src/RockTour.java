import java.util.Arrays;

public class RockTour {
    // enter value of N for different grid (different size of chess board).
    static int N = 2;
    static int [][] board = new int[N][N];

    // Possible moves for Rock
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};

    static boolean solve (int x, int y, int moveCount) {
        if (moveCount == N * N) {
            return true;
        }
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(nextX, nextY)) {
                board[nextX][nextY] = moveCount;
                if (solve(nextX, nextY,moveCount+1)){
                    return true;
                }
                board[nextX][nextY] = -1; // Backtracking
            }
        }
        return false;
    }

    static boolean isValid (int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    static void printBoard() {
        for (int [] row : board) {
            for (int cell : row) {
                System.out.printf("%3d",cell);
            }
            System.out.println();
        }
    }

    public static void main (String [] args) {
        for (int [] row : board){
            Arrays.fill(row, -1);
        }
        int startX = 0, startY = 0;
        board[startX][startY] = 0;

        if (solve(startX, startY,1)) {
            printBoard();
        }else {
            System.out.println("No solution found.");
        }
    }
}
