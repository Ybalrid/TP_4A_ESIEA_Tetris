package model;

import java.util.Arrays;

/**
 * Created by kuro on 10/03/16.
 */
public class Grid {

    private int[][] grid;
    public final static int DEFAULT_GRID_VALUE = -1;

    public Grid() {
        this.grid = new int[10][21];
        for (int[] column : grid)
            Arrays.fill(column, DEFAULT_GRID_VALUE);
    }

    public int[][] get() {
        return grid;
    }

    public int get(Position pos) {
        return grid[pos.getX()][pos.getY()];
    }

    public void set(Position pos, int value) {
        grid[pos.getX()][pos.getY()] = value;
    }

    public int getWidth() {
        return this.grid.length;
    }

    public int getHeight() {
        return this.grid[0].length;
    }
}
