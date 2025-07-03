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
                {0,3,6},
                {5,8,1},
                {2,7,4}
        };
        int n = grid.length;
        System.out.println(isValid(grid,0,0,n,0));

    }
}
