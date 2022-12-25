// 790. Domino and Tromino Tiling

package Leetcode;

import java.util.*;

public class Dominos {

    public int[][] fillGrid(int[] toFill, int[] grid) {
        int[][] result = new int[2][grid.length];
        for (int x : toFill) {
            grid[x] = 1;
        }

        int[] ans = { toFill.length==0 ? 0 : 1 };
        result[0] = ans;
        result[1] = grid;
        return result;
    }

    public int[][] vertDominos(int[] grid) {
        // Fill vertical
        for (int i = 0; i < grid.length / 2; i++) {
            if (grid[i] == 0 && grid[i + 4] == 0) {
                System.out.println("Fill Vertical Domino!");
                return fillGrid(new int[]{i, i+4}, grid);
            }
        }

        return fillGrid(new int[]{}, grid);
    }

    public int[][] horDominos(int[] grid) {
        // Fill vertical
        int[][] result = new int[2][grid.length];
        for (int i = 0; i < grid.length / 2; i = i + 2) {
            if (grid[i] == 0 && grid[i + 1] == 0) {
                System.out.println("Fill Horizontal Domino!");
                return fillGrid(new int[]{i, i+1}, grid);
            }
        }

        return fillGrid(new int[]{}, grid);
    }

    public int[][] Tromino(int[] grid) {
        // Fill vertical
        int[][] result = new int[2][grid.length];
        for (int i = 0; i < grid.length / 2 - 1; i++) {
            List<Integer> unused = new ArrayList<>();
            for (int x : new int[]{0,1,4,5}) {
                if (grid[i+x] == 0) {
                    unused.add(x);
                }
            }
            if (unused.size() == 3) {
                return fillGrid(new int[]{unused.get(0),unused.get(1), unused.get(2)}, grid);
            } else if (unused.size() == 4) {

            }
        }

        return fillGrid(new int[]{}, grid);
    }

    public boolean isFull(int[] grid) {
        for (int i=0; i<grid.length; i++) {
            if (grid[i] == 0) {
                return false;
            }
        }
        return 
        true;
    }
    public int numTilings(int n) {
        int filled = 0;
        int[] grid = new int[2*n];
        for (int x : grid) {
            x = 0;
        }

        // Fill up with Dominos Only

        while (!isFull(grid)) {
            int[][] result = new int[2][grid.length];
            result = vertDominos(grid);
            if (result[0][0] == 0) {
                System.out.println("Fill Vert Domino fail!");
                result = horDominos(grid);
                if (result[0][0] == 0) {
                    System.out.println("Not Fillable.");
                }
            }
        }
        // Fill up with Trominos Only

        // Fill up with Dominos and Trominos
    }
}
