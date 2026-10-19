package org.dsa._code_regular_revision._graphs_;

public class GraphsDFS {
    private static int count = 0;
    public static int dfs(int[][] grid, int r, int c, int[][] visit) {

        int ROWS = grid.length;
        int COLUMNS = grid[0].length;

        if (r < 0 || c < 0|| r == ROWS || c == COLUMNS ||
                visit[r][c] == 1 || grid[r][c] == 1 ) {
            return 0;
        }

        if(r == ROWS-1 && c == COLUMNS-1) {
            return 1;
        }

        visit[r][c] = 1;

        int count = 0;
        count += dfs(grid, r-1, c, visit);
        count += dfs(grid, r+1, c, visit);
        count += dfs(grid, r, c-1, visit);
        count += dfs(grid, r, c+1, visit);

        visit[r][c] = 0;
        return count;
    }

    public static void main(String[] args) {
        int[][] grid =
                {{0,0,0,0},
                 {1,1,0,0},
                 {0,0,0,1},
                 {0,1,0,0}};

        int[][] visit = new int[grid.length][grid[0].length];
        System.out.println("Find Val: " + dfs(grid, 0, 0, visit));
    }
}
