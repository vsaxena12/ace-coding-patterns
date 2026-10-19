package org.dsa._code_regular_revision._graphs_;

public class GraphsBFS {

    public static int bdf(int[][] grid, int r, int c, int[][] visit) {

        int count  = 0;
        return count;
    }

    public static void main(String[] args) {
        int[][] grid =
                {{0,0,0,0},
                 {1,1,0,0},
                 {0,0,0,1},
                 {0,1,0,0}};

        int[][] visit = new int[grid.length][grid[0].length];
        System.out.println("Find Val: " + bdf(grid, 0, 0, visit));
    }
}
