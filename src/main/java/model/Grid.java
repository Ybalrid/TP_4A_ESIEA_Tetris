package model;

/**
 * Created by kuro on 10/03/16.
 */
public class Grid {

    private int[][] grid;

    public Grid() {
        this.grid = new int[10][21];
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
        return this.grid.length;
    }
}
