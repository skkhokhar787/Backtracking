public class KnightTour {
    public static boolean isValid (int [][] grid, int r, int c, int n, int exVal) {
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != exVal) {
            return false;
        }

        if (exVal == n*n-1) {
            return true;
        }

        // 8 possible moves
        boolean ans1 = isValid(grid, r-2, c+1, n, exVal+1);
        boolean ans2 = isValid(grid, r-1, c+2, n, exVal+1);
        boolean ans3 = isValid(grid, r+1, c+2, n, exVal+1);
        boolean ans4 = isValid(grid, r+2, c+1, n, exVal+1);
        boolean ans5 = isValid(grid, r+2, c-1, n, exVal+1);
        boolean ans6 = isValid(grid, r+1, c-2, n, exVal+1);
        boolean ans7 = isValid(grid, r-1, c-2, n, exVal+1);
        boolean ans8 = isValid(grid, r-2, c-1, n, exVal+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
    public static void main (String [] args) {
        int [][] grid = {
                {0, 59, 38, 33, 30, 17,  8, 63},
                {37, 34, 31, 60,  9, 62, 29, 16},
                {58,  1, 36, 39, 32, 27, 18,  7},
                {35, 48, 41, 26, 61, 10, 15, 28},
                {42, 57,  2, 49, 40, 23,  6, 19},
                {47, 50, 45, 54, 25, 20, 11, 14},
                {56, 43, 52,  3, 22, 13, 24,  5},
                {51, 46, 55, 44, 53,  4, 21, 12}
        };
        int n = grid.length;
        System.out.println(isValid(grid,0,0,n,0));

    }
}
