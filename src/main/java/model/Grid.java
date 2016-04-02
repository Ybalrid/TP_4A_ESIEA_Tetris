package model;

import java.util.Arrays;

/**
 * Created by kuro on 10/03/16.
 */
public class Grid {

    private int[][] grid;

    public final static int DEFAULT_GRID_VALUE = -1;
    public final static int WIDTH = 10;
    public final static int HEIGHT = 21;

    public Grid() {
        this.grid = new int[WIDTH][HEIGHT];
        for (int[] column : grid)
            Arrays.fill(column, DEFAULT_GRID_VALUE);
    }

    /** Return a copy of the grid */
    public Grid applyTetromino(Tetromino tetromino) {
        Grid modifiedGrid = new Grid();
        for (int i = 0; i < WIDTH; i++)
            for (int j = 0; j < HEIGHT; j++)
                modifiedGrid.set(new Position(i, j), this.grid[i][j]);
        for (Position pos : tetromino) // TODO: iterator
            modifiedGrid.set(pos, tetromino.getType());
        return modifiedGrid;
    }

    public int get(Position pos) {
        return grid[pos.getX()][pos.getY()];
    }

    public void set(Position pos, int value) {
        grid[pos.getX()][pos.getY()] = value;
    }


}
