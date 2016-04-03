package model;

import java.util.Arrays;

/**
 * Created by Tenma on 10/03/16.
 */
public class Grid {

    private int[][] grid;

    public final static int DEFAULT_GRID_VALUE = -1;
    public final static int WIDTH = 10;
    public final static int HEIGHT = 21;

    public Grid() {
        this.grid = this.createGrid();
    }

    private int[][] createGrid() {
        int[][] grid = new int[WIDTH][HEIGHT];
        for (int[] column : grid)
            Arrays.fill(column, DEFAULT_GRID_VALUE);
        return grid;
    }

    public int get(Position pos) {
        return grid[pos.getX()][pos.getY()];
    }

    public void set(Position pos, int value) {
        grid[pos.getX()][pos.getY()] = value;
    }

    /** Return a copy of the grid with a tetromino applied into */
    public int[][] applyTetromino(Tetromino tetromino) {
        int[][] modifiedGrid = this.createGrid();

        for (int i = 0; i < WIDTH; i++)
            for (int j = 0; j < HEIGHT; j++)
                modifiedGrid[i][j] = this.grid[i][j];

        for (Position blockPos : tetromino)
            modifiedGrid[blockPos.getX() + tetromino.getPosition().getX()][blockPos.getY() + tetromino.getPosition().getY()] =
                    tetromino.getType().ordinal();

        return modifiedGrid;
    }

    public int update() {
        int nbLinesCleared = this.checkAndClearLines();
        if (nbLinesCleared == 0)
            this.fall();
        return nbLinesCleared;
    }

    private void fall() {
        for (int y = HEIGHT - 1; y > 1; y++)
            if (this.isLineVoid(y))
                for (int x = 0; x < WIDTH; x++)
                    this.grid[x][y] = this.grid[x][y-1];
    }

    private int checkAndClearLines() {
        int clearCount = 0;
        for (int y = 0; y < HEIGHT; y++) {
            if (this.isLineFull(y)) {
                this.clearLine(y);
                clearCount++;
            }
        }
        return clearCount;
    }

    private boolean isLineFull(int y) {
        for (int x = 0; x < WIDTH; x++)
            if (this.grid[x][y] <= DEFAULT_GRID_VALUE)
                return false;
        return true;
    }

    private boolean isLineVoid(int y) {
        for (int x = 0; x < WIDTH; x++)
            if (this.grid[x][y] > DEFAULT_GRID_VALUE)
                return false;
        return true;
    }

    private void clearLine(int y) {
        for (int x = 0; x < WIDTH; x++)
            this.grid[x][y] = DEFAULT_GRID_VALUE;
    }
}
